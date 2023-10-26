package com.isbill.controller;

import com.isbill.dto.BillFormDto;
import com.isbill.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String billForm(BillFormDto billFormDto) {
        billService.saveBill(billFormDto);
        return "redirect:/";
    }
}
