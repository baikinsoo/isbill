package com.isbill.FreeComment.service;

import com.isbill.FreeBoard.infrastructure.FreeBoard;
import com.isbill.FreeComment.infrastructure.FreeComment;
import com.isbill.Member.infrastructure.Member;
import com.isbill.FreeComment.domain.FreeCommentDto;
import com.isbill.FreeComment.infrastructure.FreeCommentRepository;
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

    public List<FreeComment> findContent(Long id) {
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
