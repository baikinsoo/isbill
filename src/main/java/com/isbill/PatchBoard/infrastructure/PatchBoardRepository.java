package com.isbill.PatchBoard.infrastructure;

import com.isbill.PatchBoard.infrastructure.PatchBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatchBoardRepository extends JpaRepository<PatchBoard, Long> {

}
