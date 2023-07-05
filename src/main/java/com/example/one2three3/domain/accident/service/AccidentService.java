package com.example.one2three3.domain.accident.service;

import com.example.one2three3.domain.accident.controller.dto.request.CreateAccidentRequest;
import com.example.one2three3.domain.accident.controller.dto.request.EndAccidentRequest;
import com.example.one2three3.domain.accident.controller.dto.response.AccidentView;
import com.example.one2three3.domain.accident.controller.dto.response.AccidentViewResponse;
import com.example.one2three3.domain.accident.entity.Accident;
import com.example.one2three3.domain.accident.entity.AccidentState;
import com.example.one2three3.domain.accident.repository.AccidentRepository;
import com.example.one2three3.domain.error.DomainException;
import com.example.one2three3.domain.error.exception.AccidentErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccidentService {

    private final AccidentRepository accidentRepository;

    public void createAccident(CreateAccidentRequest request) {
        accidentRepository.save(
                Accident.generate(
                        request.getLocation(),
                        request.getContent(),
                        request.getDisasterType(),
                        request.getAccount()
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

    public AccidentViewResponse getAccident() {
        List<Accident> accident = accidentRepository.findAllByState(AccidentState.GENERATION);

        List<AccidentView> viewList = accident.stream().map(AccidentView::of)
                .toList();

        return new AccidentViewResponse(viewList);
    }
}
