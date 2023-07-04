package com.example.one2three3.domain.support.controller.dto.response;

import com.example.one2three3.domain.support.repository.SupportRepository;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class SupportAmountResponse implements Serializable {

    private Long supportAmount;
}
