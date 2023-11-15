package com.isbill.repository;

import com.isbill.domain.Bill;
import com.isbill.domain.QBill;
import com.isbill.dto.BillSearchDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class BillRepositoryCustomImpl implements BillRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    private BooleanExpression billName(String searchQuery) {
        return StringUtils.isEmpty(searchQuery) ? null :
                QBill.bill.name.like("%" + searchQuery + "%");
    }

    @Override
    public List<Bill> getBillList(BillSearchDto billSearchDto) {
        QueryResults<Bill> billQueryResults = jpaQueryFactory
                .selectFrom(QBill.bill)
                .where(billName(billSearchDto.getSearchQuery()))
                .fetchResults();

        List<Bill> results = billQueryResults.getResults();

        return results;
    }
}
