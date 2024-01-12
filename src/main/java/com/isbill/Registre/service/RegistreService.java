package com.isbill.Registre.service;

import com.isbill.Registre.infrastructure.Registre;
import com.isbill.Registre.domain.RegistreSearchDto;
import com.isbill.Registre.infrastructure.RegistreRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class RegistreService {

    private final RegistreRepository registreRepository;

    @Transactional(readOnly = true)
    public Page<Registre> getMainPage(RegistreSearchDto registreSearchDto, Pageable pageable) {
        return registreRepository.getRegistreList(registreSearchDto, pageable);
    }

    public Registre findMember(Long id) {
        return registreRepository.findByMemberId(id);
    }

    public void changeName(Long id, String name) {
        Registre registre = registreRepository.findByMemberId(id);
        registre.changeName(name);
        registreRepository.save(registre);
    }
}
