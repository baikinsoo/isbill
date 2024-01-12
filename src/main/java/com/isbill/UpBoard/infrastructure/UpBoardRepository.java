package com.isbill.UpBoard.infrastructure;

import com.isbill.UpBoard.infrastructure.UpBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpBoardRepository extends JpaRepository<UpBoard, Long> {
}
