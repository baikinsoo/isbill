package com.isbill.controller;

import com.isbill.constant.Role;
import com.isbill.domain.FreeBoard;
import com.isbill.domain.FreeComment;
import com.isbill.domain.Member;
import com.isbill.dto.FreeBoardFormDto;
import com.isbill.dto.FreeCommentDto;
import com.isbill.service.FreeBoardService;
import com.isbill.service.FreeCommentService;
import com.isbill.service.PrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/freeBoard")
public class FreeBoardController {

    private final FreeBoardService freeBoardService;
    private final PrincipalService principalService;
    private final FreeCommentService freeCommentService;

    @GetMapping()
    public String freeBoard(Model model) {
        List<FreeBoard> freeBoardList = freeBoardService.findAll();
        model.addAttribute("freeBoardList", freeBoardList);
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
                              Principal principal, Model model) {

        if (bindingResult.hasErrors()) {
            return "freeBoard/newContent";
        }

        Member member = principalService.findMember(principal);

        freeBoardService.saveContent(freeBoardFormDto, member);

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
}
