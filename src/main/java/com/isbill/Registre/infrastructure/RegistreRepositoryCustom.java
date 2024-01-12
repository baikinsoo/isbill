package com.isbill.Registre.infrastructure;

import com.isbill.Registre.infrastructure.Registre;
import com.isbill.Registre.domain.RegistreSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RegistreRepositoryCustom {

    Page<Registre> getRegistreList(RegistreSearchDto registreSearchDto, Pageable pageable);
}
