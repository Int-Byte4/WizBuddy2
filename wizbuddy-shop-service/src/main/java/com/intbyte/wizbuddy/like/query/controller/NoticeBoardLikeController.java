package com.intbyte.wizbuddy.like.query.controller;

import com.intbyte.wizbuddy.like.query.service.NoticeBoardLikedService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("noticeBoardLikedQueryController")
@RequestMapping("/noticeboardlike")
public class NoticeBoardLikeController {

    private final NoticeBoardLikedService noticeBoardLikedService;

    public NoticeBoardLikeController(NoticeBoardLikedService noticeBoardLikedService) {
        this.noticeBoardLikedService = noticeBoardLikedService;
    }

    @Operation(summary = "공지사항 게시글 별 좋아요 조회")
    @GetMapping("/{noticeCode}")
    public ResponseEntity<List<Map<String, Object>>> getNoticeBoardLikesByNoticeCode(@RequestParam int noticeCode) {
        List<Map<String, Object>> response = noticeBoardLikedService.findLikesByNoticeCode(noticeCode);

        return ResponseEntity.ok(response);
    }
}
