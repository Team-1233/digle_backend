package com.example.one2three3.domain.accident.controller;

import com.example.one2three3.domain.accident.controller.dto.request.AccidentRequest;
import com.example.one2three3.domain.accident.service.AccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accident")
@RequiredArgsConstructor
public class AccidentController {

    private final AccidentService accidentService;
    @PostMapping
    public void createAccident(AccidentRequest request) {
        accidentService.createAccident(request);
    }
}
