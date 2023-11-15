package com.isbill.repository;

import com.isbill.domain.Bill;
import com.isbill.dto.BillSearchDto;

import java.util.List;

public interface BillRepositoryCustom {

    List<Bill> getBillList(BillSearchDto billSearchDto);
}
