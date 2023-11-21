package com.isbill.controller;

import com.isbill.constant.Role;
import com.isbill.domain.Member;
import com.isbill.domain.Money;
import com.isbill.domain.Registre;
import com.isbill.domain.RegistreBill;
import com.isbill.repository.BillRepository;
import com.isbill.repository.RegistreBillRepository;
import com.isbill.repository.RegistreRepository;
import com.isbill.service.MoneyService;
import com.isbill.service.PrincipalService;
import com.isbill.service.RegistreBillService;
import com.isbill.service.RegistreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/registre")
public class RegistreController {

//    private final RegistreRepository registreRepository;
//    private final RegistreBillRepository registreBillRepository;

    private final RegistreBillService registreBillService;
    private final MoneyService moneyService;
    private final PrincipalService principalService;
    private final RegistreService registreService;

    @GetMapping("/list/{registreId}")
    public String billList(@PathVariable("registreId") Long registreId, Model model) {

        List<Money> moneyList = new ArrayList<>();

//        List<RegistreBill> registreBills = registreBillRepository.findAllByRegistre_Id(registreId);
        List<RegistreBill> registreBills = registreBillService.findAllByRegistreId(registreId);
        for (RegistreBill x : registreBills) {
            Money money = moneyService.LastMoney(x.getId());
            moneyList.add(money);
        }

        model.addAttribute("moneyList", moneyList);

        return "registre/registreMain";
    }

    @GetMapping("/myRegistre")
    public ResponseEntity<Map<String, String>> newContent(Principal principal) {
        Map<String, String> responseData = new HashMap<>();
        Member member = principalService.findMember(principal);
//        Registre registre = registreRepository.findByMemberId(member.getId());
        Registre registre = registreService.findMember(member.getId());
        String userId = String.valueOf(registre.getId());
        responseData.put("userId", userId);
        return ResponseEntity.ok(responseData);
    }
}
