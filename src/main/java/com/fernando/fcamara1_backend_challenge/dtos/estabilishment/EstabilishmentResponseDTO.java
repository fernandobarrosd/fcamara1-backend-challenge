package com.fernando.fcamara1_backend_challenge.dtos.estabilishment;

import com.fernando.fcamara1_backend_challenge.dtos.ResponseDTO;
import lombok.*;


@Getter
@Setter
public class EstabilishmentResponseDTO extends ResponseDTO {
    private String name;
    private String addrees;
    private String telephone;
    private Long quantityMotocyclesVacancies;
    private Long quantityCarsVacancies;

    public EstabilishmentResponseDTO(Long id, String name, String addrees, String telephone,
                                     Long quantityMotocyclesVacancies,
                                     Long quantityCarsVacancies) {
        super(id);
        this.name = name;
        this.addrees = addrees;
        this.telephone = telephone;
        this.quantityMotocyclesVacancies = quantityMotocyclesVacancies;
        this.quantityCarsVacancies = quantityCarsVacancies;
    }
}