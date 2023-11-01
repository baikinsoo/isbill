package com.isbill.controller;

import com.isbill.constant.Role;
import com.isbill.domain.Member;
import com.isbill.domain.PatchBoard;
import com.isbill.dto.PatchBoardFormDto;
import com.isbill.dto.UpBoardFormDto;
import com.isbill.repository.PatchBoardRepository;
import com.isbill.service.PatchBoardService;
import com.isbill.service.PrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/patch")
public class PatchBoardController {

    private final PatchBoardRepository patchBoardRepository;
    private final PatchBoardService patchBoardService;
    private final PrincipalService principalService;

    @GetMapping()
    public String patchBoard(Model model) {

        List<PatchBoard> all = patchBoardRepository.findAll();

        model.addAttribute("patchBoard", all);

        return "patch/patchBoardList";
    }

    @GetMapping("/new")
    public String newContent(Model model) {

        PatchBoardFormDto patchBoardFormDto = new PatchBoardFormDto();
        model.addAttribute("patchBoardFormDto", patchBoardFormDto);

        return "patch/newContent";
    }

    @PostMapping("/new")
    public String saveContent(@Valid PatchBoardFormDto patchBoardFormDto,
                              BindingResult bindingResult,
                              Principal principal, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("patchBoard", patchBoardFormDto);
            return "patch/newContent";
        }

        Member member = principalService.findMember(principal);

        patchBoardService.saveContent(patchBoardFormDto, member);

        return "redirect:/upBoard";
    }

    @GetMapping("/{patchBoardId}")
    public String content(@PathVariable("patchBoardId") Long patchBoardId, Model model) {

        PatchBoard one = patchBoardService.findOne(patchBoardId);

        model.addAttribute("patchBoard", one);

        return "/patch/PBContent";
    }
}
