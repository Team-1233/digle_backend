package com.example.one2three3.domain.notification.controller.dto.response;

import com.example.one2three3.domain.notification.entity.Notification;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
public class NotificationResponse implements Serializable {

    private Long id;

    private String message;

    public static NotificationResponse of(Notification notification) {
        return NotificationResponse.builder()
                .id(notification.getId())
                .message(notification.getMassage())
                .build();
    }
}
