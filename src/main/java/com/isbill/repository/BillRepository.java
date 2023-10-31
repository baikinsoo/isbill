package com.isbill.repository;

import com.isbill.domain.Bill;
import com.isbill.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BillRepository extends JpaRepository<Bill, Long> {
    Bill findByNameAndMember_Id(String name, Long Id);

    Bill findByMember_Id(Long id);

    List<Bill> findAllByMember_Id(Long id);
}
