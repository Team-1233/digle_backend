package com.example.one2three3.domain.notification.service;

import com.example.one2three3.domain.notification.controller.dto.request.NotificationRequest;
import com.example.one2three3.domain.notification.controller.dto.response.NotificationResponse;
import com.example.one2three3.domain.notification.entity.Notification;
import com.example.one2three3.domain.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void createNotification(NotificationRequest request) {
        notificationRepository.save(
                Notification.builder()
                        .massage(request.getMessage())
                        .build());
    }

    public List<NotificationResponse> inquireNotification() {
        List<Notification> notification = notificationRepository.findAll();

        return notification.stream().map(NotificationResponse::of)
                .toList();
    }
}
