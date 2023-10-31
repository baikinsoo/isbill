package com.isbill.controller;

import com.isbill.domain.Bill;
import com.isbill.domain.Member;
import com.isbill.dto.BillFormDto;
import com.isbill.service.BillService;
import com.isbill.service.PrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;
    private final PrincipalService principalService;

    @GetMapping("/new")
    public String billForm(Model model) {
        model.addAttribute("billFormDto", new BillFormDto());
        return "bill/billForm";
    }

    @PostMapping("/new")
    public String createBill(@Validated BillFormDto billFormDto, BindingResult bindingResult, Model model, Principal principal) {



        if (bindingResult.hasErrors()) {
            return "bill/billForm";
        }

        String name = billFormDto.getName();
        Bill bill = billService.findBill(name, principal);

        if (bill != null) {
            bindingResult.rejectValue("name", "error.billFormDto", "이미 존재하는 채무자 이름입니다.");
            return "bill/billForm";
        }

        billService.saveBill(billFormDto, principal);
        return "redirect:/";
    }
}
