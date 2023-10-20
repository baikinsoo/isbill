package com.isbill.controller;

import com.isbill.dto.MoneyFormDto;
import com.isbill.service.MoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/money")
public class MoneyController {

    private final MoneyService moneyService;

    @GetMapping("/new")
    public String moneyFrom(Model model) {
        model.addAttribute("moneyFormDto", new MoneyFormDto());
        return "/money/moneyForm";
    }

    @PostMapping("/new")
    public String moneyNew(MoneyFormDto moneyFormDto) {
        moneyService.saveMoney(moneyFormDto);
        return "redirect:/";
    }
}
