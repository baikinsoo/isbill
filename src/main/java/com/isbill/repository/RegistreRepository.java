package com.isbill.repository;

import com.isbill.domain.Registre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistreRepository extends JpaRepository<Registre, Long> {

    Registre findByMemberId(Long id);
}
