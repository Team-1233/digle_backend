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
                Accident.generate(
                        request.getLocation(),
                        request.getContent(),
                        request.getDisasterType()
                )
        );
    }
}
