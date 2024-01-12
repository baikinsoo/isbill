package com.isbill.PatchBoard.service;

import com.isbill.Member.infrastructure.Member;
import com.isbill.PatchBoard.infrastructure.PatchBoard;
import com.isbill.PatchBoard.domain.PatchBoardFormDto;
import com.isbill.PatchBoard.infrastructure.PatchBoardRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class PatchBoardService {

    private final PatchBoardRepository patchBoardRepository;

    public void delete(Long patchId) {
        patchBoardRepository.deleteById(patchId);
    }

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

    public void editContent(PatchBoard patchBoard, PatchBoardFormDto patchBoardFormDto) {
        patchBoard.setTitle(patchBoardFormDto.getTitle());
        patchBoard.setContent(patchBoardFormDto.getContent());
        patchBoardRepository.save(patchBoard);
    }

    public List<PatchBoard> findAll() {
        return patchBoardRepository.findAll();
    }
}
