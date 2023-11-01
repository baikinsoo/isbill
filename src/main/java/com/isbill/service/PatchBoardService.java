package com.isbill.service;

import com.isbill.domain.Member;
import com.isbill.domain.PatchBoard;
import com.isbill.dto.PatchBoardFormDto;
import com.isbill.repository.PatchBoardRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class PatchBoardService {

    private final PatchBoardRepository patchBoardRepository;

    public void saveContent(PatchBoardFormDto patchBoardFormDto, Member member) {

        PatchBoard patchBoard = new PatchBoard();
        patchBoard.setTitle(patchBoardFormDto.getTitle());
        patchBoard.setContent(patchBoardFormDto.getContent());
        patchBoard.setMember(member);

        patchBoardRepository.save(patchBoard);
    }

    public PatchBoard findOne(Long id) {
        return patchBoardRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
