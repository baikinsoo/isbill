package com.isbill.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/money")
public class moneyController {

    @GetMapping("/new")
    public String newMoney() {
        return "moneyForm";
    }
}
