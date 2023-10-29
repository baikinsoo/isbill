package com.isbill.repository;

import com.isbill.domain.Money;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoneyRepository extends JpaRepository<Money, Long> {
    List<Money> findByRegistreBill_Id(Long id1);
}
