package com.isbill.Bill.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;


public interface BillRepository extends JpaRepository<Bill, Long>,
        QuerydslPredicateExecutor<Bill>, BillRepositoryCustom{

    Bill findByNameAndMember_Id(String name, Long Id);

    Bill findByMember_Id(Long id);

    List<Bill> findAllByMember_Id(Long id);
}
