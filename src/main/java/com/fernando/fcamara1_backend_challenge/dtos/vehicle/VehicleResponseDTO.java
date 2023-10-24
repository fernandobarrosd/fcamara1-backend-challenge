package com.fernando.fcamara1_backend_challenge.dtos.vehicle;

import com.fernando.fcamara1_backend_challenge.dtos.ResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleResponseDTO extends ResponseDTO {
    private String brand;
    private String model;
    private String color;
    private String plate;
    private String type;

    public VehicleResponseDTO(Long id, String brand, String model, String color, String plate,
                              String type) {
        super(id);
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.plate = plate;
        this.type = type;
    }
}
