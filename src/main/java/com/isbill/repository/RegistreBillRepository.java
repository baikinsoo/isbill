package com.isbill.repository;

import com.isbill.domain.RegistreBill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistreBillRepository extends JpaRepository<RegistreBill, Long> {

    RegistreBill findByRegistre_IdAndBill_Id(Long registreId, Long billId);

    RegistreBill findByRegistre_Id(Long registreId);

    List<RegistreBill> findAllByRegistre_Id(Long registreId);
}
