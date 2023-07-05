package com.example.one2three3.domain.error.exception;

import com.example.one2three3.domain.error.ErrorCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DomainErrorCode implements ErrorCode {

    BAD_REQUEST("DOMAIN-001", 400)

    ;

    private final String code;
    private final int status;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
