package com.isbill.service;

import com.isbill.domain.Registre;
import com.isbill.dto.RegistreSearchDto;
import com.isbill.repository.RegistreRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class RegistreService {

    private final RegistreRepository registreRepository;

    @Transactional(readOnly = true)
    public List<Registre> getMainPage(RegistreSearchDto registreSearchDto) {
        return registreRepository.getRegistreList(registreSearchDto);
    }
}
