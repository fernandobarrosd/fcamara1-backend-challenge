package com.fernando.fcamara1_backend_challenge.dtos.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class VehicleRequestDTO {
    private String brand;
    private String model;
    private String color;
    private String plate;
    private String type;
}
