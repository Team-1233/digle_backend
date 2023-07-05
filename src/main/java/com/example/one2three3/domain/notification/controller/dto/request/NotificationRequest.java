package com.example.one2three3.domain.notification.controller.dto.request;

import com.example.one2three3.domain.accident.entity.AccidentType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotificationRequest {

    @NotBlank
    private String message;

    @NotNull
    private Long accidentId;

    @NotNull
    private String type;

}
