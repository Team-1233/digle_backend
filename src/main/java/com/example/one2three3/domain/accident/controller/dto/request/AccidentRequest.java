package com.example.one2three3.domain.accident.controller.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccidentRequest {

    private String location;

    private String content;

    private String disasterType;
}
