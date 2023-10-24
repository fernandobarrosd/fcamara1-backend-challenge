package com.fernando.fcamara1_backend_challenge.dtos.estabilishment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EstabilishmentRequestDTO  {
    private String name;
    private String addrees;
    private String cnpj;
    private String telephone;
    private Long quantityMotocyclesVacancies;
    private Long quantityCarsVacancies;

}