package com.isbill.repository;

import com.isbill.domain.Money;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRepository extends JpaRepository<Money, Long> {

}
