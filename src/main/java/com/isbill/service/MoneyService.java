package com.isbill.service;

import com.isbill.domain.Bill;
import com.isbill.domain.Money;
import com.isbill.dto.MoneyFormDto;
import com.isbill.repository.BillRepository;
import com.isbill.repository.MoneyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoneyService {

    private final MoneyRepository moneyRepository;
    private final BillRepository billRepository;

    public void saveMoney(MoneyFormDto moneyFormDto) {

        // 전달 받은 DTO의 billId를 통해 bill 객체를 가져온다.
        Bill bill = billRepository.findById(moneyFormDto.getBillId())
                .orElseThrow(RuntimeException::new);

        Money lastMoney = null;
        //얘도 사실 미리 값을 만들어서 꼭 필요한 코드는 아님...

        List<Money> moneyList = moneyRepository.findByBill_Id(moneyFormDto.getBillId());
//        사실 미리 값을 하나 생성해서 넣기 때문에 삭제 기능을 넣지 않아서 뭐... 아래 코드는 딱히 필요하지 않을듯...
        // 그래도 일단 그냥 나중에 필요할 지 몰라서 작성해두자...
        if (!moneyList.isEmpty()) {
            lastMoney = moneyList.get(moneyList.size() - 1);
        } else {
            throw new RuntimeException("결과가 없습니다.");
        }

        //
        Integer remainMoney = lastMoney.getRemainMoney();
        Integer borrowMoneyAll = lastMoney.getBorrowMoneyAll();
        Integer payMoneyAll = lastMoney.getPayMoneyAll();

        //money 객체 생성
        Money money = new Money();
        money.setBill(bill);
        money.setBorrowMoney(moneyFormDto.getBorrowMoney());
        money.setPayMoney(moneyFormDto.getPayMoney());
        money.setRemainMoney(remainMoney + moneyFormDto.getBorrowMoney() - moneyFormDto.getPayMoney());
        money.setBorrowMoneyAll(borrowMoneyAll + moneyFormDto.getBorrowMoney());
        money.setPayMoneyAll(payMoneyAll + moneyFormDto.getPayMoney());

        moneyRepository.save(money);
    }

    public List<Money> findMonies() {
        return moneyRepository.findAll();
    }

    public List<Money> findLastMoney() {
        List<Bill> billList = billRepository.findAll();
        List<Money> monies = new ArrayList<>();
        if (billList.isEmpty()) {
            return null;
        } else {
            for (Bill bill : billList) {
                List<Money> moneyList = moneyRepository.findByBill_Id(bill.getId());
                Money lastMoney = moneyList.get(moneyList.size() - 1);
                monies.add(lastMoney);
            }
        }
        return monies;
    }

    public List<Money> findMoneyList(Long id) {
        return moneyRepository.findByBill_Id(id);
    }
}

