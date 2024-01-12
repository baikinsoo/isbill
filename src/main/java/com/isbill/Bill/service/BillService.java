package com.isbill.Bill.service;

import com.isbill.Bill.infrastructure.Bill;
import com.isbill.Member.infrastructure.Member;
import com.isbill.Bill.domain.BillFormDto;
import com.isbill.Bill.domain.BillSearchDto;
import com.isbill.Bill.infrastructure.BillRepository;
import com.isbill.common.service.PrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;
    private final PrincipalService principalService;

    public void saveBill(BillFormDto billFormDto, Principal principal) {

        Member member = principalService.findMember(principal);

        Bill bill = new Bill();
        bill.setName(billFormDto.getName());
        bill.setMember(member);

        billRepository.save(bill);
    }

    public List<Bill> findBills() {
        return billRepository.findAll();
    }

    public List<Bill> findMemberBills(Principal principal) {
        Member member = principalService.findMember(principal);
        return billRepository.findAllByMember_Id(member.getId());
    }

    public Bill findBill(String name, Principal principal) {
        Member member = principalService.findMember(principal);
        Bill bill = billRepository.findByNameAndMember_Id(name, member.getId());
        if (bill != null) {
            return bill;
        } else {
            return bill = null;
        }
    }

    @Transactional(readOnly = true)
    public List<Bill> getMainBillPage(BillSearchDto billSearchDto) {
        return billRepository.getBillList(billSearchDto);
    }

    public Bill findById(Long id) {
        return billRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
