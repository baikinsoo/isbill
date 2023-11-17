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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final RegistreRepository registreRepository;
    private final RegistreService registreService;

    @GetMapping("/")
    public String main(RegistreSearchDto registreSearchDto, Optional<Integer> page, Model model) {
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 5);
        List<Registre> registres = registreRepository.findAll();
        Page<Registre> mainPage = registreService.getMainPage(registreSearchDto, pageable);
        model.addAttribute("registreSearchDto", registreSearchDto);
        model.addAttribute("registres", mainPage);
        model.addAttribute("maxPage", 5);
        log.info("/ GetMapping 정상 동작------------------------------------------------------");
        return "main";
    }
}
