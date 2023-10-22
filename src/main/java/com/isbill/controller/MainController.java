package com.isbill.controller;

import com.isbill.domain.Bill;
import com.isbill.domain.Money;
import com.isbill.dto.BillFormDto;
import com.isbill.repository.BillRepository;
import com.isbill.service.BillService;
import com.isbill.service.MoneyService;
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
    private final MoneyService moneyService;

    @GetMapping("/")
    public String main(Model model) {
        List<Money> lastMoney = moneyService.findLastMoney();
        // 엔티티가 직접 넘어가는 것은 별로 좋지 않은 것 같다... 수정해야 할 것 같다...
        model.addAttribute("lastMoney", lastMoney);
        return "main";
    }
}
