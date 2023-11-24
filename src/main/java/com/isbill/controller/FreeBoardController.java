package com.isbill.controller;

import com.isbill.constant.Role;
import com.isbill.domain.FreeBoard;
import com.isbill.domain.FreeComment;
import com.isbill.domain.Member;
import com.isbill.dto.FreeBoardFormDto;
import com.isbill.dto.FreeBoardSearchDto;
import com.isbill.dto.FreeCommentDto;
import com.isbill.service.FreeBoardService;
import com.isbill.service.FreeCommentService;
import com.isbill.service.PrincipalService;
import com.isbill.service.S3UploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/freeBoard")
@Slf4j
public class FreeBoardController {

    private final FreeBoardService freeBoardService;
    private final PrincipalService principalService;
    private final FreeCommentService freeCommentService;
    private final S3UploadService s3UploadService;

    @GetMapping()
    public String freeBoard(FreeBoardSearchDto freeBoardSearchDto, Optional<Integer> page, Model model) {

        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);
        Page<FreeBoard> freeBoards = freeBoardService.pagingFindAll(pageable);
        Page<FreeBoard> freeBoardPage = freeBoardService.getFreeBoardPage(freeBoardSearchDto, pageable);

//        List<FreeBoard> freeBoardList = freeBoardService.findAll();
        model.addAttribute("freeBoardSearchDto", freeBoardSearchDto);
        model.addAttribute("freeBoardList", freeBoardPage);
        model.addAttribute("maxPage", 5);
        return "freeBoard/freeBoardList";
    }

    @GetMapping("/new")
    public String newContent(Model model) {

        model.addAttribute("freeBoardFormDto", new FreeBoardFormDto());

        return "freeBoard/newContent";
    }

    @PostMapping("/new")
    public String saveContent(@Validated FreeBoardFormDto freeBoardFormDto,
                              BindingResult bindingResult,
                              Principal principal, Model model) throws IOException {

        if (bindingResult.hasErrors()) {
            return "freeBoard/newContent";
        }

        String url = s3UploadService.saveFile(freeBoardFormDto.getAttachFile());

        Member member = principalService.findMember(principal);

        freeBoardService.saveContent(freeBoardFormDto, member, url);

        return "redirect:/freeBoard";
    }

    @GetMapping("/{freeBoardId}")
    public String Content(@PathVariable("freeBoardId") Long freeBoardId, Model model) {

        FreeBoard freeBoard = freeBoardService.findOne(freeBoardId);
        List<FreeComment> freeComments = freeCommentService.findCotent(freeBoardId);

        model.addAttribute("freeBoard", freeBoard);
        model.addAttribute("freeCommentDto", new FreeCommentDto());
        model.addAttribute("freeComments", freeComments);

        return "freeBoard/FBContent";
    }

    @PostMapping("/{freeBoardId}")
    public String comment(@PathVariable("freeBoardId") Long freeBoardId,
                          @Validated @ModelAttribute("freeCommentDto") FreeCommentDto freeCommentDto,
                          Principal principal) {

        FreeBoard one = freeBoardService.findOne(freeBoardId);
        Member member = principalService.findMember(principal);
        freeCommentService.saveComment(one, member, freeCommentDto);

        return "redirect:/freeBoard/" + freeBoardId;
    }

    @GetMapping("/newContent")
    public ResponseEntity newContent(Principal principal) {
        Member member = null;
        if (principal != null) {
            member = principalService.findMember(principal);
            if (member.getRole() == Role.NONE) {
                return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
            }
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/{freeBoardId}/delete")
    public ResponseEntity<String> delete(@PathVariable("freeBoardId") Long freeBoardId) {
        freeCommentService.deleteFBComment(freeBoardId);
        try {
            freeBoardService.delete(freeBoardId);
            return ResponseEntity.ok("삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제에 실패했습니다.");
        }
    }

    @GetMapping("/{freeBoardId}/deleteFile")
    public ResponseEntity<String> deleteFile(@PathVariable("freeBoardId") Long freeBoardId) {
        FreeBoard one = freeBoardService.findOne(freeBoardId);
        FreeBoard freeBoard = freeBoardService.deleteUrl(one);
        s3UploadService.deleteFile(one.getAWSUrl());
        return ResponseEntity.ok("삭제되었습니다.");
    }

    @GetMapping("/{freeBoardId}/edit")
    public String editFreeBoardForm(@PathVariable("freeBoardId") Long freeBoardId, Model model) {

        FreeBoard one = freeBoardService.findOne(freeBoardId);

        model.addAttribute("freeBoardFormDto", new FreeBoardFormDto());
        model.addAttribute("freeBoard", one);

        return "freeBoard/editContent";
    }

    @PostMapping("/{freeBoardId}/edit")
    public String editFreeBoard(@PathVariable("freeBoardId") Long freeBoardId, @ModelAttribute("freeBoard") FreeBoardFormDto freeBoardFormDto) throws IOException {

        if (freeBoardFormDto.getAttachFile().isEmpty()) {
            FreeBoard one = freeBoardService.findOne(freeBoardId);
            freeBoardService.editContent(one, freeBoardFormDto, null);
        } else {
            String url = s3UploadService.saveFile(freeBoardFormDto.getAttachFile());
            FreeBoard one = freeBoardService.findOne(freeBoardId);
            s3UploadService.deleteFile(one.getAWSUrl());
            freeBoardService.editContent(one, freeBoardFormDto, url);
        }
        return "redirect:/freeBoard/" + freeBoardId;
    }
}
