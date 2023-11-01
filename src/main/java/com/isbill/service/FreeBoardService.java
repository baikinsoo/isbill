package com.isbill.service;

import com.isbill.domain.FreeBoard;
import com.isbill.domain.Member;
import com.isbill.dto.FreeBoardFormDto;
import com.isbill.repository.FreeBoardRepository;
import com.isbill.repository.FreeCommentRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;

    public void saveContent(FreeBoardFormDto freeBoardFormDto, Member member) {

        FreeBoard freeBoard = new FreeBoard();
        freeBoard.setTitle(freeBoardFormDto.getTitle());
        freeBoard.setContent(freeBoardFormDto.getContent());
        freeBoard.setMember(member);

        freeBoardRepository.save(freeBoard);
    }

    public List<FreeBoard> findAll() {
        return freeBoardRepository.findAll();
    }

    public FreeBoard findOne(Long id) {
        return freeBoardRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public void delete(Long id) {
        freeBoardRepository.deleteById(id);
    }
}
