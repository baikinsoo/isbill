package com.isbill.repository;

import com.isbill.domain.QRegistre;
import com.isbill.domain.Registre;
import com.isbill.dto.RegistreSearchDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
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
    public List<Registre> getRegistreList(RegistreSearchDto registreSearchDto) {
        QueryResults<Registre> registreQueryResults = jpaQueryFactory.selectFrom(QRegistre.registre)
                .where(registreName(registreSearchDto.getSearchQuery()))
                .fetchResults();

        List<Registre> results = registreQueryResults.getResults();

        return results;
    }
}
