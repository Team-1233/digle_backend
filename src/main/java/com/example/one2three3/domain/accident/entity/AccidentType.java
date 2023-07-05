package com.example.one2three3.domain.accident.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccidentType {

    FIRE("화재"),
    HEAVY_RAIN("폭우"),
    EARTHQUAKE("지진"),
    TYPHOON("태풍"),
    DUST_STORM("황사"),
    WAR("전쟁"),
    DROUGHT("가뭄"),

    ;

    private final String name;
}
