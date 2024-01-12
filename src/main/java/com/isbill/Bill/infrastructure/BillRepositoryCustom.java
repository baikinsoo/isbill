package com.isbill.Bill.infrastructure;

import com.isbill.Bill.infrastructure.Bill;
import com.isbill.Bill.domain.BillSearchDto;

import java.util.List;

public interface BillRepositoryCustom {

    List<Bill> getBillList(BillSearchDto billSearchDto);
}
