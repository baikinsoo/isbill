package com.isbill.controller;

import com.isbill.constant.Role;
import com.isbill.constant.Upgrade;
import com.isbill.domain.FreeBoard;
import com.isbill.domain.UpBoard;
import com.isbill.domain.Member;
import com.isbill.dto.FreeBoardFormDto;
import com.isbill.dto.UpBoardFormDto;
import com.isbill.dto.UpgradeDto;
import com.isbill.repository.MemberRepository;
import com.isbill.service.MemberService;
import com.isbill.service.MoneyService;
import com.isbill.service.UpBoardService;
import com.isbill.service.PrincipalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/upBoard")
@Slf4j
public class UpBoardController {

//    private final MemberRepository memberRepository;

    private final UpBoardService upBoardService;
    private final PrincipalService principalService;
    private final MemberService memberService;

    @GetMapping()
    public String upBoard(Model model) {
        List<UpBoard> upBoardList = upBoardService.findAll();
        model.addAttribute("upBoardList", upBoardList);
        return "upBoard/upBoardList";
    }

    @PostMapping()
    public String upgrade(Principal principal) {
        String name = principal.getName();
//        Member member = memberRepository.findByEmail(name);
        Member member = memberService.findByEmail(name);
        upBoardService.changeYes(member);
        return "redirect:upBoard";
    }

    @GetMapping("/new")
    public String newContent(Model model) {

        model.addAttribute("upBoardFormDto", new UpBoardFormDto());

        return "upBoard/newContent";
    }

    @PostMapping("/new")
    public String saveContent(@Valid UpBoardFormDto upBoardFormDto,
                              BindingResult bindingResult,
                              Principal principal,
                              Model model) {

        if (bindingResult.hasErrors()) {
            return "upBoard/newContent";
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

    @GetMapping("/admin")
    public String upgrade(Model model) {
        ArrayList<Member> members = new ArrayList<>();
//        List<Member> all = memberRepository.findAll();
        List<Member> all = memberService.findAll();
        for (Member x : all) {
            if (x.getRole()==Role.NONE && x.getUpgrade() == Upgrade.YES) {
                members.add(x);
            }
        }
        model.addAttribute("members", members);
        return "upBoard/upgradeList";
    }

    @PostMapping("/admin")
    public String endUpgrade(UpgradeDto upgradeDto) {

        upBoardService.upgrade(upgradeDto);

        return "redirect:/upBoard/admin";
    }

    @DeleteMapping("/{upBoardId}")
    public ResponseEntity<String> delete(@PathVariable("upBoardId") Long upBoardId) {

        try {
            upBoardService.delete(upBoardId);
            return ResponseEntity.ok("삭제되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제에 실패했습니다.");
        }
    }

    @GetMapping("/{upBoardId}/edit")
    public String editFreeBoardForm(@PathVariable("upBoardId") Long upBoardId, Model model) {

        UpBoard one = upBoardService.findOne(upBoardId);

        model.addAttribute("upBoard", one);

        return "upBoard/editContent";
    }

    @PostMapping("/{upBoardId}/edit")
    public String editFreeBoard(@PathVariable("upBoardId") Long upBoardId, @ModelAttribute("upBoard") UpBoardFormDto upBoardFormDto) {

        UpBoard one = upBoardService.findOne(upBoardId);
        upBoardService.editContent(one, upBoardFormDto);

        return "redirect:/upBoard/" + upBoardId;
    }
}
