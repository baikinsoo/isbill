package com.isbill.service;

import com.isbill.domain.Bill;
import com.isbill.domain.Money;
import com.isbill.domain.Registre;
import com.isbill.domain.RegistreBill;
import com.isbill.dto.MoneyFormDto;
import com.isbill.repository.BillRepository;
import com.isbill.repository.MoneyRepository;
import com.isbill.repository.RegistreBillRepository;
import com.isbill.repository.RegistreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MoneyService {

    private final MoneyRepository moneyRepository;
    private final BillRepository billRepository;
    private final RegistreBillRepository registreBillRepository;

    public void saveMoney(MoneyFormDto moneyFormDto, Registre registre, Bill bill) {
        // 지금 DB에서 마지막 이전과 비교해서 저장하다 보니 뭔가 서비스 코드가 매우 지저분하다... 음... List로 전부 더하면 계산할때 마다 연산이..
        // 내가 고려할 사항이 아닌가...? 이정도는 요즘 장비로 다 커버 가능하겠지..?

        // 전달 받은 DTO의 billId를 통해 bill 객체를 가져온다.
//        Bill bill = billRepository.findById(moneyFormDto.getBillId())
//                .orElseThrow(RuntimeException::new);
        // 그냥 파라미터로 받아버렸다.

        //-------------------------------
        Money lastMoney = null;
        //얘도 사실 미리 값을 만들어서 음... 없앨 방법을 찾아보자...

        RegistreBill registreBill = registreBillRepository.findByRegistre_IdAndBill_Id(registre.getId(), bill.getId());

        List<Money> moneyList = moneyRepository.findByRegistreBill_Id(registreBill.getId());
//        사실 미리 값을 하나 생성해서 넣기 때문에 삭제 기능을 넣지 않아서 뭐... 아래 코드는 딱히 필요하지 않을듯...
        // 그래도 일단 그냥 나중에 필요할 지 몰라서 작성해두자...
        if (!moneyList.isEmpty()) {
            lastMoney = moneyList.get(moneyList.size() - 1);
        } else {
            throw new RuntimeException("결과값이 없습니다.");
        }

        //--------------------
        //이게 꼭 이렇게 작성해야 하는지 한 번 생각해보기...
        Long remainMoney = lastMoney.getRemainMoney();
        Long borrowMoneyAll = lastMoney.getBorrowMoneyAll();
        Long payMoneyAll = lastMoney.getPayMoneyAll();

        //---------------------------
        //money 객체 생성
        Money money = new Money();
        money.setRegistreBill(registreBill);
        money.setBorrowMoney(moneyFormDto.getBorrowMoney());
        money.setPayMoney(moneyFormDto.getPayMoney());
        money.setRemainMoney(remainMoney + moneyFormDto.getBorrowMoney() - moneyFormDto.getPayMoney());
        money.setBorrowMoneyAll(borrowMoneyAll + moneyFormDto.getBorrowMoney());
        money.setPayMoneyAll(payMoneyAll + moneyFormDto.getPayMoney());
        money.setBorrowItemName(moneyFormDto.getBorrowItemName());
        money.setPayItemName(moneyFormDto.getPayItemName());
        // 이것도 엔티티에서 생성자로 만들어서 코드를 줄 일 수 있을 것 같음...

        // 사실 DB에 최종 빌린 돈 갚은 돈을 저장 안하면 위와 같이 귀찮게 계산하는 코드를 짤 필요가 없긴하다.
        moneyRepository.save(money);
    }

    public List<Money> findMonies() {
        return moneyRepository.findAll();
    }

    public List<Money> findLastMoney() {
//        List<Bill> billList = billRepository.findAll();
        List<RegistreBill> RBList = registreBillRepository.findAll();
        List<Money> monies = new ArrayList<>();
        for (RegistreBill bill : RBList) {
            List<Money> moneyList = moneyRepository.findByRegistreBill_Id(bill.getId());
            if (!moneyList.isEmpty()) {
                Money lastMoney = moneyList.get(moneyList.size() - 1);
                monies.add(lastMoney);
            }
        }
        return monies.isEmpty() ? null : monies;
    }

    public List<Money> findMoneyList(Long id) {
        return moneyRepository.findByRegistreBill_Id(id);
    }

    public Money findMoney(Long id) {
        return moneyRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}

