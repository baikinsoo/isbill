package com.isbill.repository;

import com.isbill.domain.Money;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MoneyRepository extends JpaRepository<Money, Long> {
    List<Money> findByBill_Id(Long id);
}
