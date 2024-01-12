package com.isbill.Registre.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface RegistreRepository extends JpaRepository<Registre, Long>,
        QuerydslPredicateExecutor<Registre>, RegistreRepositoryCustom {

    Registre findByMemberId(Long id);
}
