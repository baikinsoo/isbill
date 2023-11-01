package com.isbill.repository;

import com.isbill.domain.FreeComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreeCommentRepository extends JpaRepository<FreeComment, Long> {

    List<FreeComment> findByFreeBoard_Id(Long id);

    List<FreeComment> deleteAllByFreeBoard_Id(Long id);
}
