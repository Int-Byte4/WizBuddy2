package com.intbyte.wizbuddy.board.service;

import com.intbyte.wizbuddy.board.domain.entity.NoticeBoard;
import com.intbyte.wizbuddy.board.dto.NoticeBoardDTO;
import com.intbyte.wizbuddy.board.repository.NoticeBoardRepository;
import com.intbyte.wizbuddy.mapper.NoticeBoardMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
public class NoticeBoardService {

    private NoticeBoardMapper noticeBoardMapper;
    private final NoticeBoardRepository noticeBoardRepository;

    public NoticeBoardService(NoticeBoardRepository noticeBoardRepository, NoticeBoardMapper noticeBoardMapper) {
        this.noticeBoardRepository = noticeBoardRepository;
        this.noticeBoardMapper = noticeBoardMapper;
    }

    public void registerNoticeBoard(NoticeBoardDTO noticeBoardInfo) {
        int shopCode = noticeBoardInfo.getShopCode();

//        예외처리 추가 필요

        NoticeBoard noticeBoard = NoticeBoard.builder()
                .noticeTitle(noticeBoardInfo.getNoticeTitle())
                .noticeContent(noticeBoardInfo.getNoticeContent())
                .noticeFlag(true)
                .imageUrl(noticeBoardInfo.getImageUrl())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .shopCode(shopCode)
                .build();

        noticeBoardRepository.save(noticeBoard);
    }
}
