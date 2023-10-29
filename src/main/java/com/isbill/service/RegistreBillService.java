package com.isbill.service;

import com.isbill.domain.Bill;
import com.isbill.domain.Money;
import com.isbill.domain.Registre;
import com.isbill.domain.RegistreBill;
import com.isbill.repository.MoneyRepository;
import com.isbill.repository.RegistreBillRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class RegistreBillService {

    private final RegistreBillRepository registreBillRepository;
    private final MoneyRepository moneyRepository;

    public void saveRB(Registre registre, Bill bill) {
        RegistreBill registreBill = new RegistreBill();
        registreBill.setRegistre(registre);
        registreBill.setBill(bill);
        RegistreBill save = registreBillRepository.save(registreBill);
        Money money = Money.createMoney(save);
        moneyRepository.save(money);
    }
}
