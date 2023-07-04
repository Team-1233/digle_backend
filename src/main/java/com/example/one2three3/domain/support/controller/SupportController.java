package com.example.one2three3.domain.support.controller;

import com.example.one2three3.domain.support.controller.dto.request.SupportRequest;
import com.example.one2three3.domain.support.controller.dto.response.SupportAmountResponse;
import com.example.one2three3.domain.support.service.SupportService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class SupportController {

    private final SupportService supportService;
    @PostMapping("/support")
    public void createSupport(SupportRequest request) {
        supportService.createSupport(request);
    }

    @GetMapping("/support")
    public SupportAmountResponse inquireSupportAmount(SupportRequest request) {
        return supportService.inquireSupportAmount(request);
    }
}
