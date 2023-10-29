package com.isbill.controller;

import com.isbill.domain.Registre;
import com.isbill.repository.RegistreRepository;
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

    @GetMapping("/")
    public String main(Model model) {
        List<Registre> registres = registreRepository.findAll();
        model.addAttribute("registres", registres);
        return "main";
    }
}
