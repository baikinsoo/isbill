package com.isbill.Money.service;

import com.isbill.Bill.infrastructure.Bill;
import com.isbill.Money.infrastructure.Money;
import com.isbill.Registre.infrastructure.Registre;
import com.isbill.RegistreBill.infrastructure.RegistreBill;
import com.isbill.Money.domain.MoneyFormDto;
import com.isbill.Money.infrastructure.MoneyRepository;
import com.isbill.RegistreBill.infrastructure.RegistreBillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MoneyService {

    private final MoneyRepository moneyRepository;
    private final RegistreBillRepository registreBillRepository;

    public void saveMoney(MoneyFormDto moneyFormDto, Registre registre, Bill bill) {

        Money lastMoney = null;

        RegistreBill registreBill = registreBillRepository.findByRegistre_IdAndBill_Id(registre.getId(), bill.getId());

        List<Money> moneyList = moneyRepository.findByRegistreBill_Id(registreBill.getId());

        if (!moneyList.isEmpty()) {
            lastMoney = moneyList.get(moneyList.size() - 1);
        } else {
            throw new RuntimeException("결과값이 없습니다.");
        }

        Long remainMoney = lastMoney.getRemainMoney();
        Long borrowMoneyAll = lastMoney.getBorrowMoneyAll();
        Long payMoneyAll = lastMoney.getPayMoneyAll();

        Money money = new Money();
        money.setRegistreBill(registreBill);
        money.setBorrowMoney(moneyFormDto.getBorrowMoney());
        money.setPayMoney(moneyFormDto.getPayMoney());
        money.setRemainMoney(remainMoney + moneyFormDto.getBorrowMoney() - moneyFormDto.getPayMoney());
        money.setBorrowMoneyAll(borrowMoneyAll + moneyFormDto.getBorrowMoney());
        money.setPayMoneyAll(payMoneyAll + moneyFormDto.getPayMoney());
        money.setBorrowItemName(moneyFormDto.getBorrowItemName());
        money.setPayItemName(moneyFormDto.getPayItemName());

        moneyRepository.save(money);
    }

    public Money LastMoney(Long id) {
        List<Money> moneyList = moneyRepository.findByRegistreBill_Id(id);
        return  moneyList.get(moneyList.size() - 1);
    }

    public List<Money> findMoneyList(Long id) {
        return moneyRepository.findByRegistreBill_Id(id);
    }
}

