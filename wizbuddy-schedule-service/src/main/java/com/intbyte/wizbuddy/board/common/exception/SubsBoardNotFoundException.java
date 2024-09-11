package com.intbyte.wizbuddy.board.common.exception;


import com.intbyte.wizbuddy.board.common.StatusEnum;

public class SubsBoardNotFoundException extends IllegalArgumentException{

    private final StatusEnum status;

    private static final String message = "해당 대타 게시글이 존재하지 않습니다.";

    public SubsBoardNotFoundException() {
        super(message);
        this.status = StatusEnum.BOARD_NOT_FOUND;
    }
}
