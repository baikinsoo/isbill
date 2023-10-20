package com.isbill.service;

import com.isbill.domain.Money;
import com.isbill.dto.MoneyFormDto;
import com.isbill.repository.MoneyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MoneyService {

    private final MoneyRepository moneyRepository;

    public void saveMoney(MoneyFormDto moneyFormDto) {

        Money money = Money.builder()
                .borrowMoney(moneyFormDto.getBorrowMoney())
                .payMoney(moneyFormDto.getPayMoney())
                .build();

        moneyRepository.save(money);
    }
}

