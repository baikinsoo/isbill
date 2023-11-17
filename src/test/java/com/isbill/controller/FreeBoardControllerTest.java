package com.isbill.controller;

import com.isbill.domain.FreeBoard;
import com.isbill.domain.QFreeBoard;
import com.isbill.dto.FreeBoardSearchDto;
import com.isbill.repository.FreeBoardRepository;
import com.isbill.service.FreeBoardService;
import com.isbill.service.RegistreBillService;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Slf4j
class FreeBoardControllerTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    FreeBoardRepository freeBoardRepository;

    @Autowired
    FreeBoardService freeBoardService;

    @Test
    @DisplayName("게시글 저장 테스트")
    public void saveFreeBoard() {
        FreeBoard freeBoard = new FreeBoard();
        freeBoard.setTitle("테스트 게시물입니다.");
        FreeBoard save = freeBoardRepository.save(freeBoard);
        System.out.println(save.toString());
    }

    @Test
    @DisplayName("엔티티 생성")
    public void newPage() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            FreeBoard freeBoard = new FreeBoard();
            freeBoard.setTitle("Title" + i);

            FreeBoard save = freeBoardRepository.save(freeBoard);
        });
    }

    @Test
    @DisplayName("페이징 테스트")
    public void pagingTest01() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            FreeBoard freeBoard = new FreeBoard();
            freeBoard.setTitle("Title" + i);

            FreeBoard save = freeBoardRepository.save(freeBoard);
            log.info("{}", save.getTitle());
        });

        Pageable pageable = PageRequest.of(0, 10);

        Page<FreeBoard> all = freeBoardRepository.findAll(pageable);
        for (FreeBoard x : all) {
            log.info(x.getTitle());
        }
    }

    @Test
    @DisplayName("@Query를 이용한 FreeBoard 상품 조회 테스트")
    public void queryTest01() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            FreeBoard freeBoard = new FreeBoard();
            freeBoard.setTitle("Title : " + i);

            FreeBoard save = freeBoardRepository.save(freeBoard);
        });

        List<FreeBoard> byFreeBoardDetail = freeBoardRepository.findByFreeBoardDetail("7");
        for (FreeBoard x : byFreeBoardDetail) {
            log.info("{}", x);
        }
    }

    @Test
    @DisplayName("Querydsl 조회 테스트 1")
    public void querydslTest() {
        this.newPage();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QFreeBoard qFreeBoard = QFreeBoard.freeBoard;
        JPAQuery<FreeBoard> query = queryFactory.selectFrom(qFreeBoard)
                .where(qFreeBoard.title.like("%" + "7" + "%"));
        List<FreeBoard> freeBoardList = query.fetch();

        for (FreeBoard x : freeBoardList) {
            log.info("{}", x);
        }
    }

    @Test
    @DisplayName("페이징 정렬 결과 테스트")
    public void test10() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            FreeBoard freeBoard = new FreeBoard();
            freeBoard.setTitle("Title" + i);

            FreeBoard save = freeBoardRepository.save(freeBoard);
            log.info("{}", save.getTitle());
        });

        FreeBoardSearchDto freeBoardSearchDto = new FreeBoardSearchDto();
        freeBoardSearchDto.setSearchQuery("Title");

        Pageable pageable = PageRequest.of(0, 10);
//        Pageable pageable = PageRequest.of(0, 10);

        Page<FreeBoard> freeBoardPage = freeBoardService.getFreeBoardPage(freeBoardSearchDto, pageable);

        Page<FreeBoard> all = freeBoardRepository.findAll(pageable);
        for (FreeBoard x : freeBoardPage) {
            log.info(x.getTitle());
        }
    }
}