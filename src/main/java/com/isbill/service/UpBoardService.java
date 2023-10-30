package com.isbill.service;

import com.isbill.domain.UpBoard;
import com.isbill.domain.Member;
import com.isbill.dto.UpBoardFormDto;
import com.isbill.repository.UpBoardRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class UpBoardService {
    private final UpBoardRepository upBoardRepository;

    public void saveContent(UpBoardFormDto upBoardFormDto, Member member) {

        UpBoard upBoard = new UpBoard();
        upBoard.setTitle(upBoardFormDto.getTitle());
        upBoard.setContent(upBoardFormDto.getContent());
        upBoard.setMember(member);

        upBoardRepository.save(upBoard);
    }

    public List<UpBoard> findAll() {
        return upBoardRepository.findAll();
    }

    public UpBoard findOne(Long id) {
        return upBoardRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
