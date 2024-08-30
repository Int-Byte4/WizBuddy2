package com.intbyte.wizbuddy.board.service;

import com.intbyte.wizbuddy.board.domain.entity.SubsBoard;
import com.intbyte.wizbuddy.board.dto.SubsBoardDTO;
import com.intbyte.wizbuddy.board.repository.SubsBoardRepository;
import com.intbyte.wizbuddy.mapper.SubsBoardMapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubsBoardService {

    private final SubsBoardMapper subsBoardMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public SubsBoardService(SubsBoardMapper subsBoardMapper, ModelMapper modelMapper) {
        this.subsBoardMapper = subsBoardMapper;
        this.modelMapper = modelMapper;
    }


    public List<SubsBoardDTO> findAllSubsBoards() {
        List<SubsBoard> subsBoardList = subsBoardMapper.selectAllSubsBoard();

        return subsBoardList.stream()
                .map(subsBoard -> modelMapper.map(subsBoard, SubsBoardDTO.class))
                .collect(Collectors.toList());
    }


    public SubsBoardDTO findSubsBoardById(int subsCode) {
        SubsBoard subsBoard = subsBoardMapper.selectSubsBoardById(subsCode);

        if (subsBoard == null) {
            throw new IllegalArgumentException("해당 subsCode에 대한 게시판 항목을 찾을 수 없습니다.");
        }

        return modelMapper.map(subsBoard, SubsBoardDTO.class);
    }



}
