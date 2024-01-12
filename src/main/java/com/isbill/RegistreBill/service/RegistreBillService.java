package com.isbill.RegistreBill.service;

import com.isbill.Bill.infrastructure.Bill;
import com.isbill.Money.infrastructure.Money;
import com.isbill.Registre.infrastructure.Registre;
import com.isbill.RegistreBill.infrastructure.RegistreBill;
import com.isbill.Money.infrastructure.MoneyRepository;
import com.isbill.RegistreBill.infrastructure.RegistreBillRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<RegistreBill> findAllByRegistreId(Long id) {
        return registreBillRepository.findAllByRegistre_Id(id);
    }

    public RegistreBill findRegistreBill(Long registreId, Long billId) {
        return registreBillRepository.findByRegistre_IdAndBill_Id(registreId, billId);
    }
}
