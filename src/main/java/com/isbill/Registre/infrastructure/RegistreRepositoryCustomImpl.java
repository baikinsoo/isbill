package com.isbill.Registre.infrastructure;

import com.isbill.Registre.domain.RegistreSearchDto;
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
public class RegistreRepositoryCustomImpl implements RegistreRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    private BooleanExpression registreName(String searchQuery) {
        return StringUtils.isEmpty(searchQuery) ? null :
                QRegistre.registre.name.like("%" + searchQuery + "%");
    }

    @Override
    public Page<Registre> getRegistreList(RegistreSearchDto registreSearchDto, Pageable pageable) {

        QueryResults<Registre> registreQueryResults = jpaQueryFactory
                .selectFrom(QRegistre.registre)
                .where(registreName(registreSearchDto.getSearchQuery()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<Registre> content = registreQueryResults.getResults();
        long total = registreQueryResults.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
