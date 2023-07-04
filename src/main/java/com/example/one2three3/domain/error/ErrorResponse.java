package com.example.one2three3.domain.error;

import java.io.Serializable;

public record ErrorResponse(String message, String code, int status) implements Serializable {

    private static final String DEFAULT_MESSAGE = "";

    public static ErrorResponse of(ErrorCode errorCode) {
        return new ErrorResponse(DEFAULT_MESSAGE, errorCode.getCode(), errorCode.getStatus());
    }

    public static ErrorResponse of(ErrorCode errorCode, String message) {
        return new ErrorResponse(message, errorCode.getCode(), errorCode.getStatus());
    }
}