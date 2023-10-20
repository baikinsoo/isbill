package com.isbill.service;

import com.isbill.domain.Bill;
import com.isbill.domain.Money;
import com.isbill.dto.BillFormDto;
import com.isbill.dto.MoneyFormDto;
import com.isbill.repository.BillRepository;
import com.isbill.repository.MoneyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public void saveBill(BillFormDto billFormDto) {
        Bill bill = Bill.builder()
                .name(billFormDto.getName())
                .build();

        billRepository.save(bill);
    }

    public List<Bill> findBill() {
        return billRepository.findAll();
    }
}
