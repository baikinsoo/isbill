package com.isbill.service;

import com.isbill.domain.FreeBoard;
import com.isbill.domain.Member;
import com.isbill.dto.FreeBoardFormDto;
import com.isbill.dto.FreeBoardSearchDto;
import com.isbill.repository.FreeBoardRepository;
import com.isbill.repository.FreeCommentRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public void editContent(FreeBoard freeBoard, FreeBoardFormDto freeBoardFormDto) {
        freeBoard.setTitle(freeBoardFormDto.getTitle());
        freeBoard.setContent(freeBoardFormDto.getContent());
        freeBoardRepository.save(freeBoard);
    }

//    페이징만을 위한 코드
    public Page<FreeBoard> pagingFindAll(Pageable pageable) {
        return freeBoardRepository.findAll(pageable);
    }

    //    페이징 및 검색을 위한 코드
    public Page<FreeBoard> getFreeBoardPage(FreeBoardSearchDto freeBoardSearchDto, Pageable pageable) {
        return freeBoardRepository.getFreeBoardList(freeBoardSearchDto, pageable);
    }

}
