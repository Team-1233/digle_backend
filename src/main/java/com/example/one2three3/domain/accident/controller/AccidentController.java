package com.example.one2three3.domain.accident.controller;

import com.example.one2three3.domain.accident.controller.dto.request.CreateAccidentRequest;
import com.example.one2three3.domain.accident.controller.dto.request.EndAccidentRequest;
import com.example.one2three3.domain.accident.controller.dto.response.AccidentViewResponse;
import com.example.one2three3.domain.accident.service.AccidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accident")
@RequiredArgsConstructor
public class AccidentController {

    private final AccidentService accidentService;

    @PostMapping
    public void createAccident(@RequestBody CreateAccidentRequest request) {
        accidentService.createAccident(request);
    }

    @PatchMapping
    public void endAccident(@Valid @RequestBody EndAccidentRequest request) {
        accidentService.endAccident(request);
    }

    @GetMapping
    public AccidentViewResponse getAccident() {
        return accidentService.getAccident();
    }
}
