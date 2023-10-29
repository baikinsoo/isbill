package com.isbill.controller;

import com.isbill.domain.Bill;
import com.isbill.dto.BillFormDto;
import com.isbill.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;

    @GetMapping("/new")
    public String billForm(Model model) {
        model.addAttribute("billFormDto", new BillFormDto());
        return "bill/billForm";
    }

    @PostMapping("/new")
    public String createBill(@Valid BillFormDto billFormDto, BindingResult bindingResult, Model model) {
        // 유효성 검사 수행
        if (bindingResult.hasErrors()) {
            return "bill/billForm"; // 에러가 있을 때 다시 입력 폼을 보여줌
        }

        String name1 = billService.findName(billFormDto.getName());
        String name2 = billFormDto.getName();

        if (name1.equals(name2)) {
            bindingResult.rejectValue("name", "error.billFormDto", "이미 존재하는 채무자 이름입니다.");
            return "bill/billForm";
        }

        billService.saveBill(billFormDto);
        return "redirect:/";
    }
}
