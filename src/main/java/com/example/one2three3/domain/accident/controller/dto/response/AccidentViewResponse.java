package com.example.one2three3.domain.accident.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class AccidentViewResponse implements Serializable {

    private List<AccidentView> currentAccident;
}
