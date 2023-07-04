package com.example.one2three3.domain.notification.controller;

import com.example.one2three3.domain.notification.controller.dto.request.NotificationRequest;
import com.example.one2three3.domain.notification.controller.dto.response.NotificationResponse;
import com.example.one2three3.domain.notification.entity.Notification;
import com.example.one2three3.domain.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/notification")
    public void createNotification(@RequestBody NotificationRequest request) {
        notificationService.createNotification(request);
    }

    @GetMapping("/notification")
    public List<NotificationResponse> inquireNotification() {
        return notificationService.inquireNotification();
    }
}
