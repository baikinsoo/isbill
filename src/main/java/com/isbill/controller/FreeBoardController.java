package com.isbill.controller;

import com.isbill.domain.FreeBoard;
import com.isbill.domain.Member;
import com.isbill.dto.FreeBoardFormDto;
import com.isbill.service.FreeBoardService;
import com.isbill.service.PrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/freeBoard")
public class FreeBoardController {

    private final FreeBoardService freeBoardService;
    private final PrincipalService principalService;

    @GetMapping()
    public String freeBoard(Model model) {
        List<FreeBoard> freeBoardList = freeBoardService.findAll();
        model.addAttribute("freeBoardList", freeBoardList);
        return "freeBoard/freeBoardList";
    }

    @GetMapping("/new")
    public String newContent(Model model) {

        model.addAttribute("freeBoardForm", new FreeBoardFormDto());

        return "freeBoard/NewContent";
    }

    @PostMapping("/new")
    public String saveContent(@Valid FreeBoardFormDto freeBoardFormDto,
                              BindingResult bindingResult,
                              Principal principal) {

        if (bindingResult.hasErrors()) {
            return "freeBoard/NewContent";
        }

        Member member = principalService.findMember(principal);

        freeBoardService.saveContent(freeBoardFormDto, member);

        return "redirect:/freeBoard";
    }

    @GetMapping("/{freeBoardId}")
    public String Content(@PathVariable("freeBoardId") Long freeBoardId, Model model) {

        FreeBoard freeBoard = freeBoardService.findOne(freeBoardId);

        model.addAttribute("freeBoard", freeBoard);

        return "freeBoard/FBContent";
    }

    @GetMapping("/newContent")
    public ResponseEntity newContent(Principal principal) {
        if (principal != null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }
}
