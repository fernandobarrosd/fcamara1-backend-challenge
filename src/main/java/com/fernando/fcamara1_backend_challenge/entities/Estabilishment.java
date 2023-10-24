package com.fernando.fcamara1_backend_challenge.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estabilishment {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String addrees;

    @Column(nullable = false, unique = true)
    private String telephone;

    @Column(nullable = false)
    private Long quantityMotocyclesVacancies;

    @Column(nullable = false)
    private Long quantityCarsVacancies;

    @OneToMany
    @JoinColumn(name = "vehicle_id")
    private List<Vehicle> vehicles;
}
