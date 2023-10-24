package com.fernando.fcamara1_backend_challenge.entities;

import com.fernando.fcamara1_backend_challenge.enums.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehicle extends BaseEntity {
    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false, unique = true)
    private String plate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    public Vehicle(Long id, String brand, String model, String color, String plate,
                   VehicleType type) {
        super(id);
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.plate = plate;
        this.type = type;
    }
}
