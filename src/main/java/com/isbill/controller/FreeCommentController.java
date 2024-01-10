package com.isbill.controller;

import com.isbill.service.FreeCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/freeComment")
public class FreeCommentController {

    private final FreeCommentService freeCommentService;

    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> delete(@PathVariable("commentId") Long commentId) {
        freeCommentService.deleteOne(commentId);
        return ResponseEntity.ok("삭제되었습니다.");
    }
}
