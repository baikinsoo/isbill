package com.isbill.FreeComment.infrastructure;

import com.isbill.FreeComment.infrastructure.FreeComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreeCommentRepository extends JpaRepository<FreeComment, Long> {

    List<FreeComment> findByFreeBoard_Id(Long id);

    List<FreeComment> deleteAllByFreeBoard_Id(Long id);
}
