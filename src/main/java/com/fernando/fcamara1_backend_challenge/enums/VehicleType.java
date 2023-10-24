package com.fernando.fcamara1_backend_challenge.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VehicleType {
    MOTOCYCLE("Motocycle"),
    CAR("Car");


    private String value;
}