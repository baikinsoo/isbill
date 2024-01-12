package com.isbill.FreeBoard.infrastructure;

import com.isbill.FreeBoard.infrastructure.FreeBoard;
import com.isbill.FreeBoard.domain.FreeBoardSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FreeBoardRepositoryCustom {

    Page<FreeBoard> getFreeBoardList(FreeBoardSearchDto freeBoardSearchDto, Pageable pageable);
}
