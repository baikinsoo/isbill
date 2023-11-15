package com.isbill.repository;

import com.isbill.domain.FreeBoard;
import com.isbill.domain.QFreeBoard;
import com.isbill.domain.QMember;
import com.isbill.dto.FreeBoardSearchDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class FreeBoardRepositoryCustomImpl implements FreeBoardRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    private BooleanExpression freeBoardMemberLike(String searchQuery) {
        return StringUtils.isEmpty(searchQuery) ? null :
                QFreeBoard.freeBoard.member.name.like("%" + searchQuery + "%");
    }

    private BooleanExpression freeBoardTitleLike(String searchQuery) {
        return StringUtils.isEmpty(searchQuery) ? null :
                QFreeBoard.freeBoard.title.like("%" + searchQuery + "%");
    }

    @Override
    public Page<FreeBoard> getFreeBoardList(FreeBoardSearchDto freeBoardSearchDto, Pageable pageable) {

        QueryResults<FreeBoard> freeBoardQueryResults = jpaQueryFactory
                .selectFrom(QFreeBoard.freeBoard)
                .where(freeBoardTitleLike(freeBoardSearchDto.getSearchQuery()))
//                .where(freeBoardMemberLike(freeBoardSearchDto.getSearchQuery()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<FreeBoard> content = freeBoardQueryResults.getResults();
        long total = freeBoardQueryResults.getTotal();
        return new PageImpl<>(content, pageable, total);
    }
}
