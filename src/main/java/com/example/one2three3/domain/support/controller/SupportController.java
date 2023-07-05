package com.example.one2three3.domain.support.controller;

import com.example.one2three3.domain.support.controller.dto.request.SupportRequest;
import com.example.one2three3.domain.support.controller.dto.response.SupportAmountResponse;
import com.example.one2three3.domain.support.service.SupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/support")
@RequiredArgsConstructor
public class SupportController {

    private final SupportService supportService;

    @PostMapping
    public void createSupport(@RequestBody SupportRequest request) {
        supportService.createSupport(request);
    }

    @GetMapping
    public SupportAmountResponse getSupportAmount(@RequestBody SupportRequest request) {
        return supportService.getSupportAmount(request);
    }
}
