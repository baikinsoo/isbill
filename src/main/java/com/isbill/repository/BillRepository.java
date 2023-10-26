package com.isbill.repository;

import com.isbill.domain.Bill;
import com.isbill.domain.Money;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    Bill findByName(String name);
}
