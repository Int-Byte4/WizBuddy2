package com.intbyte.wizbuddy.checklist.query.service;

import com.intbyte.wizbuddy.common.exception.CommonException;
import com.intbyte.wizbuddy.common.exception.StatusEnum;
import com.intbyte.wizbuddy.checklist.query.dto.CheckListQueryDTO;
import com.intbyte.wizbuddy.checklist.query.repository.CheckListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckListServiceImpl implements CheckListService {

    private final CheckListMapper checkListMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public CheckListServiceImpl(CheckListMapper checkListMapper, ModelMapper modelMapper) {
        this.checkListMapper = checkListMapper;
        this.modelMapper = modelMapper;
    }

    // 1. 특정 체크리스트 조회
    @Override
    public CheckListQueryDTO findCheckListById(int checkListCode){

        CheckListQueryDTO checkList = checkListMapper.findCheckListById(checkListCode);

        if(checkList == null) throw new CommonException(StatusEnum.CHECKLIST_NOT_FOUND);

        return checkList;
    }

    // 2. flag가 true 인 특정 매장의 모든 체크리스트 조회
    @Override
    public List<CheckListQueryDTO> findCheckListByIdByShop(int shopCode){

        return checkListMapper.findAllCheckListByShopId(shopCode);
    }
}
