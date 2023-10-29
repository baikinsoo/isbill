package com.isbill.repository;

import com.isbill.domain.RegistreBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistreBillRepository extends JpaRepository<RegistreBill, Long> {
    RegistreBill findByRegistre_IdAndBill_Id(Long registreId, Long billId);
}
