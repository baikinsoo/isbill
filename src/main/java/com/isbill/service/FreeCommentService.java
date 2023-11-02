package com.isbill.service;

import com.isbill.domain.FreeBoard;
import com.isbill.domain.FreeComment;
import com.isbill.domain.Member;
import com.isbill.dto.FreeCommentDto;
import com.isbill.repository.FreeCommentRepository;
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
public class FreeCommentService {

    private final FreeCommentRepository freeCommentRepository;

    public void saveComment(FreeBoard freeBoard, Member member, FreeCommentDto freeCommentDto) {
        FreeComment freeComment = new FreeComment();
        freeComment.setFreeBoard(freeBoard);
        freeComment.setMember(member);
        freeComment.setContent(freeCommentDto.getContent());
        freeCommentRepository.save(freeComment);
    }

    public List<FreeComment> findCotent(Long id) {
        return freeCommentRepository.findByFreeBoard_Id(id);
    }

    @Transactional
    public void deleteFBComment(Long id) {
        freeCommentRepository.deleteAllByFreeBoard_Id(id);
    }

    public void deleteOne(Long id) {
        freeCommentRepository.deleteById(id);
    }

}
