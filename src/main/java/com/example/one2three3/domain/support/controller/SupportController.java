package com.example.one2three3.domain.support.controller;

import com.example.one2three3.domain.support.controller.dto.request.SupportRequest;
import com.example.one2three3.domain.support.controller.dto.response.SupportAmountResponse;
import com.example.one2three3.domain.support.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/support")
@RequiredArgsConstructor
public class SupportController {

    private final SupportService supportService;
    @PostMapping
    public void createSupport(SupportRequest request) {
        supportService.createSupport(request);
    }

    @GetMapping
    public SupportAmountResponse inquireSupportAmount(SupportRequest request) {
        return supportService.inquireSupportAmount(request);
    }
}
