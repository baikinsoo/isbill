package com.isbill.controller;

import com.isbill.domain.Money;
import com.isbill.domain.RegistreBill;
import com.isbill.repository.BillRepository;
import com.isbill.repository.RegistreBillRepository;
import com.isbill.service.MoneyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/registre")
public class RegistreController {

    private final RegistreBillRepository registreBillRepository;
    private final MoneyService moneyService;

    @GetMapping("/list/{registreId}")
    public String billList(@PathVariable("registreId") Long registreId, Model model) {

        List<Money> moneyList = new ArrayList<>();

        List<RegistreBill> registreBills = registreBillRepository.findAllByRegistre_Id(registreId);
        for (RegistreBill x : registreBills) {
            Money money = moneyService.LastMoney(x.getId());
            moneyList.add(money);
        }

        model.addAttribute("moneyList", moneyList);

        return "registre/registreMain";
    }
}
