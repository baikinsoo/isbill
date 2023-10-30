package com.isbill.controller;

import com.isbill.domain.*;
import com.isbill.dto.MoneyFormDto;
import com.isbill.repository.BillRepository;
import com.isbill.repository.MemberRepository;
import com.isbill.repository.RegistreBillRepository;
import com.isbill.repository.RegistreRepository;
import com.isbill.service.BillService;
import com.isbill.service.MoneyService;
import com.isbill.service.RegistreBillService;
import lombok.RequiredArgsConstructor;
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
public class MoneyController {

    private final MoneyService moneyService;
    private final BillService billService;
    private final MemberRepository memberRepository;
    private final RegistreRepository registreRepository;
    private final RegistreBillRepository registreBillRepository;
    private final BillRepository billRepository;
    private final RegistreBillService registreBillService;

    @GetMapping("/new")
    public String moneyFrom(Model model) {

        List<Bill> bills = billService.findBills();

        model.addAttribute("bills", bills);
        model.addAttribute("moneyFormDto", new MoneyFormDto());
        return "money/moneyForm";
    }

    @PostMapping("/new")
    public String moneyNew(@Valid @ModelAttribute MoneyFormDto moneyFormDto, BindingResult bindingResult, Model model, Principal principal) {

        if (bindingResult.hasErrors()) {
            List<Bill> bills = billService.findBills();
            model.addAttribute("bills", bills);
            return "money/moneyForm";
        }
        String name = principal.getName();
        Member member = memberRepository.findByEmail(name);
        Registre registre = registreRepository.findByMemberId(member.getId());
        Bill bill = billRepository.findById(moneyFormDto.getBillId())
                .orElseThrow(RuntimeException::new);
        RegistreBill registreBill = registreBillRepository.findByRegistre_IdAndBill_Id(registre.getId(), bill.getId());
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
}
