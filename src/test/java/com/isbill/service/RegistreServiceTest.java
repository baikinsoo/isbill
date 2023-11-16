package com.isbill.service;

import com.isbill.domain.Registre;
import com.isbill.dto.RegistreSearchDto;
import com.isbill.repository.RegistreRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class RegistreServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    RegistreService registreService;

    @Autowired
    RegistreRepository registreRepository;

    @Test
    @DisplayName("registre 페이징 조회 테스트")
    public void registrePagingTest() {
        RegistreSearchDto registreSearchDto = new RegistreSearchDto();
        registreSearchDto.setSearchQuery("asd");
        Pageable pageable = PageRequest.of(0, 5);
        Page<Registre> mainPage = registreService.getMainPage(registreSearchDto, pageable);

        for (Registre x : mainPage) {
            log.info("{}", x);
        }
    }
}