package com.example.one2three3.domain.error.exception;

import com.example.one2three3.domain.error.ErrorCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccidentErrorCode implements ErrorCode {

    NOT_FOUND("ACCIDENT_001", 404)

    ;

    private final String code;
    private final int status;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
