package com.example.one2three3.domain.notification.controller;

import com.example.one2three3.domain.notification.controller.dto.request.NotificationRequest;
import com.example.one2three3.domain.notification.controller.dto.response.NotificationResponse;
import com.example.one2three3.domain.notification.entity.Notification;
import com.example.one2three3.domain.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void createNotification(@Valid @RequestBody NotificationRequest request) {
        notificationService.createNotification(request);
    }

    @GetMapping
    public List<NotificationResponse> inquireNotification() {
        return notificationService.getNotification();
    }
}
