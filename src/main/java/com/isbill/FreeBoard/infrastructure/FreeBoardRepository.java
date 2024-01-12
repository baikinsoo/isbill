package com.isbill.FreeBoard.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long>,
        QuerydslPredicateExecutor<FreeBoard>, FreeBoardRepositoryCustom {

    @Query("select f from FreeBoard f where f.title like %:freeBoardDetail%")
    List<FreeBoard> findByFreeBoardDetail(@Param("freeBoardDetail") String freeBoardDetail);
}
