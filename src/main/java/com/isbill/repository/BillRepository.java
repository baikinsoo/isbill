package com.isbill.repository;

import com.isbill.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BillRepository extends JpaRepository<Bill, Long> {
    Bill findByName(String name);
}
