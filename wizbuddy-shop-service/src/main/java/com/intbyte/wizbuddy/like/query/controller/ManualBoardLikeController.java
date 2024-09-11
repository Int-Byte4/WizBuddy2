package com.intbyte.wizbuddy.like.query.controller;


import com.intbyte.wizbuddy.like.query.dto.ManualBoardLikedDTO;
import com.intbyte.wizbuddy.like.query.service.ManualBoardLikedService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manualboardlike")
public class ManualBoardLikeController {

    private final ManualBoardLikedService manualBoardLikedService;

    public ManualBoardLikeController(ManualBoardLikedService manualBoardLikedService) {
        this.manualBoardLikedService = manualBoardLikedService;
    }

    @Operation(summary = "매뉴얼 게시글 별 좋아요 조회")
    @GetMapping("/{manualCode}")
    public ResponseEntity<List<ManualBoardLikedDTO>> getManualBoardLikesByManualCode(@RequestParam int manualCode) {
        List<ManualBoardLikedDTO> response = manualBoardLikedService.findLikesByManualCode(manualCode);

        return ResponseEntity.ok(response);
    }
}
