package com.isbill.service;

import com.isbill.domain.Bill;
import com.isbill.domain.Member;
import com.isbill.dto.BillFormDto;
import com.isbill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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

}
