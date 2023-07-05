package com.example.one2three3.domain.support.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SupportRequest {

    @NotBlank
    private String contributorName;

    @NotNull
    private Long supportAmount;

    @NotNull
    private Long accidentId;
}
