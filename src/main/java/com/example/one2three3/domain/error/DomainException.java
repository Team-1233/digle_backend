package com.example.one2three3.domain.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DomainException extends RuntimeException {

    public final ErrorCode errorCode;

}
