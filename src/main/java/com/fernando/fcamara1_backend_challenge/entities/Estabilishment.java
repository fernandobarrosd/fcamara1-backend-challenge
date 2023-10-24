package com.fernando.fcamara1_backend_challenge.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Estabilishment extends BaseEntity {
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

    public Estabilishment(Long id, String name, String cnpj, String addrees,
                          String telephone, Long quantityMotocyclesVacancies,
                          Long quantityCarsVacancies, List<Vehicle> vehicles) {
        super(id);
        this.name = name;
        this.cnpj = cnpj;
        this.addrees = addrees;
        this.telephone = telephone;
        this.quantityMotocyclesVacancies = quantityMotocyclesVacancies;
        this.quantityCarsVacancies = quantityCarsVacancies;
        this.vehicles = vehicles;
    }
}
