package com.example.one2three3.domain.support.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SupportRequest {

    private String contributorName;

    private Long supportAmount;

    private Long accidentId;
}
