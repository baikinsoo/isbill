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

    private final MoneyService moneyService;
    private final BillRepository billRepository;
    private final MoneyRepository moneyRepository;

    public void saveBill(BillFormDto billFormDto) {

        Bill bill = new Bill();
        bill.setName(billFormDto.getName());

        Money money = new Money();
        money.setBill(bill);

        billRepository.save(bill);
        moneyRepository.save(money);
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
