package com.isbill.repository;

import com.isbill.domain.Registre;
import com.isbill.dto.RegistreSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RegistreRepositoryCustom {

    Page<Registre> getRegistreList(RegistreSearchDto registreSearchDto, Pageable pageable);
}
