package com.example.one2three3.domain.accident.controller.dto.response;

import com.example.one2three3.domain.accident.entity.Accident;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@Builder
public class AccidentView {

    private Long id;

    private String location;

    private String content;

    private String temporaryAccount;

    private String type;

    private LocalDateTime time;

    public static AccidentView of(Accident accident) {
        return AccidentView.builder()
                .id(accident.getId())
                .location(accident.getLocation())
                .content(accident.getContent())
                .temporaryAccount(accident.getTemporaryAccount())
                .type(accident.getType().getName())
                .time(accident.getTime())
                .build();
    }
}
