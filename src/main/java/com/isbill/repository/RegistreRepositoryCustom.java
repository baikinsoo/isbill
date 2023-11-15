package com.isbill.repository;

import com.isbill.domain.Registre;
import com.isbill.dto.RegistreSearchDto;

import java.util.List;

public interface RegistreRepositoryCustom {

    List<Registre> getRegistreList(RegistreSearchDto registreSearchDto);
}
