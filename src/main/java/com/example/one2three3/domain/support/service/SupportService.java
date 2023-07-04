package com.example.one2three3.domain.support.service;

import com.example.one2three3.domain.accident.entity.Accident;
import com.example.one2three3.domain.accident.repository.AccidentRepository;
import com.example.one2three3.domain.support.controller.dto.request.SupportRequest;
import com.example.one2three3.domain.support.controller.dto.response.SupportAmountResponse;
import com.example.one2three3.domain.support.entity.Support;
import com.example.one2three3.domain.support.repository.SupportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportService {

    private final SupportRepository supportRepository;
    private final AccidentRepository accidentRepository;

    public void createSupport(SupportRequest request) {

        Accident accident = accidentRepository.findById(request.getAccidentId())
                .orElseThrow();

        supportRepository.save(
                Support.builder()
                        .contributorName(request.getContributorName())
                        .supportAmount(request.getSupportAmount())
                        .accident(accident)
                        .build());
    }

    public SupportAmountResponse inquireSupportAmount(SupportRequest request) {

        Long supportAmount = supportRepository.sumByAccidentIdWithSupportMoney(request.getAccidentId());

        return SupportAmountResponse.builder()
                .supportAmount(supportAmount)
                .build();
    }
}
