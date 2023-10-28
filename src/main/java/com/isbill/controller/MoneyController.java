package com.isbill.controller;

import com.isbill.domain.Bill;
import com.isbill.domain.Money;
import com.isbill.dto.BillFormDto;
import com.isbill.dto.MoneyFormDto;
import com.isbill.service.BillService;
import com.isbill.service.MoneyService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/money")
public class MoneyController {

    private final MoneyService moneyService;
    private final BillService billService;

    @GetMapping("/new")
    public String moneyFrom(Model model) {

        List<Bill> bills = billService.findBills();

        model.addAttribute("bills", bills);
        model.addAttribute("moneyFormDto", new MoneyFormDto());
        return "money/moneyForm";
    }

    @PostMapping("/new")
    public String moneyNew(@Validated @ModelAttribute MoneyFormDto moneyFormDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            List<Bill> bills = billService.findBills();
            model.addAttribute("bills", bills);
            return "money/moneyForm";
        }
        moneyService.saveMoney(moneyFormDto);
        return "redirect:/";
    }

    @GetMapping("list/{billId}")
    public String moneyList(@PathVariable("billId") Long billId, Model model) {
        List<Money> moneyList = moneyService.findMoneyList(billId);
        model.addAttribute("moneyList", moneyList);
        return "money/moneyListForm";
    }
}
