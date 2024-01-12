package com.isbill.Money.controller;

import com.isbill.Bill.infrastructure.Bill;
import com.isbill.Bill.service.BillService;
import com.isbill.Member.infrastructure.Member;
import com.isbill.Member.service.MemberService;
import com.isbill.Money.infrastructure.Money;
import com.isbill.Money.service.MoneyService;
import com.isbill.Registre.infrastructure.Registre;
import com.isbill.Registre.service.RegistreService;
import com.isbill.RegistreBill.infrastructure.RegistreBill;
import com.isbill.RegistreBill.service.RegistreBillService;
import com.isbill.common.service.PrincipalService;
import com.isbill.constant.Role;
import com.isbill.Money.domain.MoneyFormDto;
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
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/money")
@Slf4j
public class MoneyController {

    private final MoneyService moneyService;
    private final BillService billService;
    private final MemberService memberService;
    private final RegistreService registreService;
    private final RegistreBillService registreBillService;
    private final PrincipalService principalService;

    @GetMapping("/new")
    public String moneyFrom(Model model, Principal principal) {

        List<Bill> bills = billService.findMemberBills(principal);

        model.addAttribute("bills", bills);
        model.addAttribute("moneyFormDto", new MoneyFormDto());

        return "money/moneyForm";
    }

    @PostMapping("/new")
    public String moneyNew(@Valid @ModelAttribute MoneyFormDto moneyFormDto, BindingResult bindingResult, Model model, Principal principal) {

        if (bindingResult.hasErrors()) {
            List<Bill> bills = billService.findMemberBills(principal);
            model.addAttribute("bills", bills);
            return "money/moneyForm";
        }
        String name = principal.getName();
        Member member = memberService.findByEmail(name);
        Registre registre = registreService.findMember(member.getId());
        Bill bill = billService.findById(moneyFormDto.getBillId());
        RegistreBill registreBill = null;
        registreBill = registreBillService.findRegistreBill(registre.getId(), bill.getId());

        if (registreBill == null) {
            registreBillService.saveRB(registre, bill);
        }
        moneyService.saveMoney(moneyFormDto, registre, bill);

        return "redirect:/";
    }

    @GetMapping("list/{registreBillId}")
    public String moneyList(@PathVariable("registreBillId") Long registreBillId, Model model) {

        List<Money> moneyList = moneyService.findMoneyList(registreBillId);
        model.addAttribute("moneyList", moneyList);

        return "money/moneyListForm";
    }

    @GetMapping("moneyNew")
    public ResponseEntity billNew(Principal principal) {

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
