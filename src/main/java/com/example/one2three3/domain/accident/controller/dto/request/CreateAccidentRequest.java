package com.example.one2three3.domain.accident.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateAccidentRequest {

    @NotBlank
    private String location;

    @NotNull
    private String content;

    @NotBlank
    private String disasterType;

    @NotBlank
    private String account;
}
