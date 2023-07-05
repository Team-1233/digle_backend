package com.example.one2three3.domain.accident.controller;

import com.example.one2three3.domain.accident.controller.dto.request.CreateAccidentRequest;
import com.example.one2three3.domain.accident.controller.dto.request.EndAccidentRequest;
import com.example.one2three3.domain.accident.service.AccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/accident")
@RequiredArgsConstructor
public class AccidentController {

    private final AccidentService accidentService;

    @PostMapping
    public void createAccident(@RequestBody AccidentRequest request) {
        accidentService.createAccident(request);
    }

    @PatchMapping
    public void endAccident(@Valid @RequestBody EndAccidentRequest request) {
        accidentService.endAccident(request);
    }
}
