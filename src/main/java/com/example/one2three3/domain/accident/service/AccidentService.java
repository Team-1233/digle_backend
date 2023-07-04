package com.example.one2three3.domain.accident.service;

import com.example.one2three3.domain.accident.controller.dto.request.AccidentRequest;
import com.example.one2three3.domain.accident.entity.Accident;
import com.example.one2three3.domain.accident.repository.AccidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccidentService {

    private final AccidentRepository accidentRepository;

    public void createAccident(AccidentRequest request) {
        accidentRepository.save(
                Accident.builder()
                        .location(request.getLocation())
                        .content(request.getContent())
                        .disasterType(request.getDisasterType())
                        .build());
    }
}
