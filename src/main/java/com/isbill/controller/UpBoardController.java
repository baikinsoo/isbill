package com.isbill.controller;

import com.isbill.domain.UpBoard;
import com.isbill.domain.Member;
import com.isbill.dto.UpBoardFormDto;
import com.isbill.service.UpBoardService;
import com.isbill.service.PrincipalService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/upBoard")
public class UpBoardController {

    private final UpBoardService upBoardService;
    private final PrincipalService principalService;

    @GetMapping()
    public String upBoard(Model model) {
        List<UpBoard> upBoardList = upBoardService.findAll();
        model.addAttribute("upBoardList", upBoardList);
        return "upBoard/upBoardList";
    }

    @GetMapping("/new")
    public String newContent(Model model) {

        model.addAttribute("upBoardForm", new UpBoardFormDto());

        return "upBoard/NewContent";
    }

    @PostMapping("/new")
    public String saveContent(@Valid UpBoardFormDto upBoardFormDto,
                              BindingResult bindingResult,
                              Principal principal) {

        if (bindingResult.hasErrors()) {
            return "upBoard/NewContent";
        }

        Member member = principalService.findMember(principal);

        upBoardService.saveContent(upBoardFormDto, member);

        return "redirect:/upBoard";
    }

    @GetMapping("/{upBoardId}")
    public String Content(@PathVariable("upBoardId") Long upBoardId, Model model) {

        UpBoard upBoard = upBoardService.findOne(upBoardId);

        model.addAttribute("upBoard", upBoard);

        return "upBoard/UBContent";
    }
}
