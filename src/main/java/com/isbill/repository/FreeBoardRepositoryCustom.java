package com.isbill.repository;

import com.isbill.domain.FreeBoard;
import com.isbill.dto.FreeBoardSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FreeBoardRepositoryCustom {

    Page<FreeBoard> getFreeBoardList(FreeBoardSearchDto freeBoardSearchDto, Pageable pageable);
}
