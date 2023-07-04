package com.example.one2three3.domain.support.service;

import com.example.one2three3.domain.accident.entity.Accident;
import com.example.one2three3.domain.accident.repository.AccidentRepository;
import com.example.one2three3.domain.support.controller.dto.request.SupportRequest;
import com.example.one2three3.domain.support.controller.dto.response.SupportAmountResponse;
import com.example.one2three3.domain.support.entity.Support;
import com.example.one2three3.domain.support.repository.SupportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public SupportAmountResponse getSupportAmount(SupportRequest request) {
        List<Support> supports = supportRepository.findAllByAccident_Id(request.getAccidentId());

        Long totalSupportAmount = supports.stream()
                .mapToLong(Support::getSupportAmount)
                .sum();

        Long todaySupportAmount = supports.stream()
                .filter(support -> support.getTime()
                        .isAfter(LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT)))
                .mapToLong(Support::getSupportAmount)
                .sum();

        return SupportAmountResponse.builder()
                .totalSupportAmount(totalSupportAmount)
                .todaySupportAmount(todaySupportAmount)
                .build();
    }
}
