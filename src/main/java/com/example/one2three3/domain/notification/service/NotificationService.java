package com.example.one2three3.domain.notification.service;

import com.example.one2three3.domain.accident.entity.Accident;
import com.example.one2three3.domain.accident.entity.AccidentType;
import com.example.one2three3.domain.accident.repository.AccidentRepository;
import com.example.one2three3.domain.error.DomainException;
import com.example.one2three3.domain.error.exception.AccidentErrorCode;
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
    private final AccidentRepository accidentRepository;

    public void createNotification(NotificationRequest request) {
        Accident accident = accidentRepository.findById(request.getAccidentId())
                .orElseThrow(() -> new DomainException(AccidentErrorCode.NOT_FOUND));

        notificationRepository.save(
                Notification.builder()
                        .massage(request.getMessage())
                        .accident(accident)
                        .build());
    }

    public List<NotificationResponse> getNotification() {
        List<Notification> notification = notificationRepository.findTop10ByOrderByTimeDesc();

        return notification.stream()
                .map(NotificationResponse::of)
                .toList();
    }
}
