package com.intbyte.wizbuddy.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeBoardMapper {
    int findEmployerCodeByNoticeCode(int noticeCode);
}
