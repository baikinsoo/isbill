package com.isbill.controller;

import com.isbill.domain.Bill;
import com.isbill.dto.BillFormDto;
import com.isbill.repository.BillRepository;
import com.isbill.service.BillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final BillService billService;

    @GetMapping("/")
    public String main(Model model) {
        List<Bill> bill = billService.findBill();
        model.addAttribute("bill", bill);
        return "main";
    }
}
