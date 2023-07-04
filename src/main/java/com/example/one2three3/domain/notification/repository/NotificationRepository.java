package com.example.one2three3.domain.notification.repository;

import com.example.one2three3.domain.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
