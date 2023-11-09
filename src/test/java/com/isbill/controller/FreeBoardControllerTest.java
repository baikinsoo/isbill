package com.isbill.controller;

import com.isbill.domain.FreeBoard;
import com.isbill.repository.FreeBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.IntStream;

@ActiveProfiles("test")
@SpringBootTest
@Slf4j
class FreeBoardControllerTest {

    @Autowired
    private FreeBoardRepository freeBoardRepository;

    @Test
    void freeBoard() {

        IntStream.rangeClosed(1,100).forEach(i->{
            FreeBoard freeBoard = new FreeBoard();
            freeBoard.setTitle("title 페이징" + i);

            FreeBoard result = freeBoardRepository.save(freeBoard);
        });

        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());

        Page<FreeBoard> result = freeBoardRepository.findAll(pageable);

        List<FreeBoard> list = result.getContent();
        list.forEach(freeBoard -> log.info("{}", freeBoard.getTitle()));
    }
}