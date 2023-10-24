package com.fernando.fcamara1_backend_challenge.services.impl;

import com.fernando.fcamara1_backend_challenge.dtos.estabilishment.EstabilishmentRequestDTO;
import com.fernando.fcamara1_backend_challenge.dtos.estabilishment.EstabilishmentResponseDTO;
import com.fernando.fcamara1_backend_challenge.entities.Estabilishment;
import com.fernando.fcamara1_backend_challenge.repositories.EstabilishmentRepository;
import com.fernando.fcamara1_backend_challenge.services.interfaces.EstabilishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstabilishmentServiceImpl implements EstabilishmentService  {
    @Autowired
    private EstabilishmentRepository estabilishmentRepository;


    @Override
    public void save(EstabilishmentRequestDTO requestDTO) {
        Estabilishment estabilishment = new Estabilishment();
        estabilishment.setName(requestDTO.getName());
        estabilishment.setCnpj(requestDTO.getCnpj());
        estabilishment.setAddrees(requestDTO.getAddrees());
        estabilishment.setVehicles(List.of());
        estabilishment.setQuantityCarsVacancies(requestDTO.getQuantityCarsVacancies());
        estabilishment.setQuantityMotocyclesVacancies(requestDTO.getQuantityMotocyclesVacancies());
        estabilishment.setTelephone(requestDTO.getTelephone());

        estabilishmentRepository.save(estabilishment);
    }

    @Override
    public EstabilishmentResponseDTO findByID(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        estabilishmentRepository.deleteById(id);
    }

    @Override
    public void update(Long id, EstabilishmentRequestDTO requestDTO) {
        Estabilishment estabilishment = new Estabilishment();
        estabilishment.setId(id);
        estabilishment.setName(requestDTO.getName());
        estabilishment.setCnpj(requestDTO.getCnpj());
        estabilishment.setAddrees(requestDTO.getAddrees());
        estabilishment.setVehicles(List.of());
        estabilishment.setQuantityCarsVacancies(requestDTO.getQuantityCarsVacancies());
        estabilishment.setQuantityMotocyclesVacancies(requestDTO.getQuantityMotocyclesVacancies());
        estabilishment.setTelephone(requestDTO.getTelephone());

        estabilishmentRepository.save(estabilishment);
    }
}
