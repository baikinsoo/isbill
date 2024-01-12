package com.isbill.common.controller;

import com.isbill.Registre.infrastructure.Registre;
import com.isbill.Registre.domain.RegistreSearchDto;
import com.isbill.Registre.service.RegistreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

//    private final RegistreRepository registreRepository;

    private final RegistreService registreService;

    @GetMapping("/")
    public String main(RegistreSearchDto registreSearchDto, Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);
//        List<Registre> registres = registreRepository.findAll();
        Page<Registre> mainPage = registreService.getMainPage(registreSearchDto, pageable);
        model.addAttribute("registreSearchDto", registreSearchDto);
        model.addAttribute("registres", mainPage);
        model.addAttribute("maxPage", 5);
        return "main";
    }
}
