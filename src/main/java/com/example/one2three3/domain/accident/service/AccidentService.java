package com.example.one2three3.domain.accident.service;

import com.example.one2three3.domain.accident.controller.dto.request.CreateAccidentRequest;
import com.example.one2three3.domain.accident.controller.dto.request.EndAccidentRequest;
import com.example.one2three3.domain.accident.entity.Accident;
import com.example.one2three3.domain.accident.repository.AccidentRepository;
import com.example.one2three3.domain.error.DomainException;
import com.example.one2three3.domain.error.exception.AccidentErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccidentService {

    private final AccidentRepository accidentRepository;

    public void createAccident(CreateAccidentRequest request) {
        accidentRepository.save(
                Accident.generate(
                        request.getLocation(),
                        request.getContent(),
                        request.getDisasterType()
                )
        );
    }

    public void endAccident(EndAccidentRequest request) {
        Accident accident = accidentRepository.findById(request.getAccidentId())
                        .orElseThrow(() -> new DomainException(AccidentErrorCode.NOT_FOUND));

        accidentRepository.save(
                accident.end()
        );
    }
}
