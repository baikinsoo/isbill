package com.isbill.controller;

import com.isbill.domain.Bill;
import com.isbill.domain.Registre;
import com.isbill.dto.BillSearchDto;
import com.isbill.dto.RegistreSearchDto;
import com.isbill.repository.RegistreRepository;
import com.isbill.service.BillService;
import com.isbill.service.RegistreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final RegistreRepository registreRepository;
    private final RegistreService registreService;

    @GetMapping("/")
    public String main(RegistreSearchDto registreSearchDto, Model model) {
        List<Registre> registres = registreRepository.findAll();
        List<Registre> mainPage = registreService.getMainPage(registreSearchDto);
        model.addAttribute("registres", mainPage);
        return "main";
    }
}
