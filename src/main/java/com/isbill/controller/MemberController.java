package com.isbill.controller;

import com.isbill.domain.Member;
import com.isbill.domain.Registre;
import com.isbill.dto.MemberEditFormDto;
import com.isbill.dto.MemberFormDto;
import com.isbill.service.MemberService;
import com.isbill.service.PrincipalService;
import com.isbill.service.RegistreService;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final PrincipalService principalService;
    private final RegistreService registreService;

    @GetMapping("/new")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }

    @PostMapping("/new")
    public String memberForm(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "member/memberForm";
        }
        try {
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "member/memberForm";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginMember() {
        return "member/memberLoginForm";

    }

    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "member/memberLoginForm";
    }

    @GetMapping("/edit")
    public String editMemberForm(Model model) {
        model.addAttribute("member", new MemberEditFormDto());
        return "member/memberEditForm";
    }

    @PostMapping("/edit")
    public String editMember(@Validated @ModelAttribute("member") MemberEditFormDto memberEditFormDto, Principal principal) {

        Member member = principalService.findMember(principal);

        Member.editMember(member, memberEditFormDto, passwordEncoder);

        memberService.editMember(member);

        registreService.changeName(member.getId(), memberEditFormDto.getName());

        return "redirect:/";
    }
}
