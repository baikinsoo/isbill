package com.isbill.RegistreBill.infrastructure;

import com.isbill.RegistreBill.infrastructure.RegistreBill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistreBillRepository extends JpaRepository<RegistreBill, Long> {

    RegistreBill findByRegistre_IdAndBill_Id(Long registreId, Long billId);

    List<RegistreBill> findAllByRegistre_Id(Long registreId);
}
