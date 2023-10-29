package com.isbill.service;

import com.isbill.domain.Bill;
import com.isbill.dto.BillFormDto;
import com.isbill.repository.BillRepository;
import com.isbill.repository.MoneyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public void saveBill(BillFormDto billFormDto) {

        Bill bill = new Bill();
        bill.setName(billFormDto.getName());
        billRepository.save(bill);
    }

    public List<Bill> findBills() {
        return billRepository.findAll();
    }

    public Bill findBill(Long id) {
        return billRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public String findName(String name) {
        Bill bill = billRepository.findByName(name);
        if (bill != null) {
            return bill.getName();
        } else {
            return "존재하지 않는 채무자";
        }
    }
}
