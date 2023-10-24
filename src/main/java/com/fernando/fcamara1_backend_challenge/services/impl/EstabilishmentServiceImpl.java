package com.fernando.fcamara1_backend_challenge.services.impl;

import com.fernando.fcamara1_backend_challenge.dtos.estabilishment.EstabilishmentRequestDTO;
import com.fernando.fcamara1_backend_challenge.dtos.estabilishment.EstabilishmentResponseDTO;
import com.fernando.fcamara1_backend_challenge.dtos.vehicle.VehicleResponseDTO;
import com.fernando.fcamara1_backend_challenge.entities.Estabilishment;
import com.fernando.fcamara1_backend_challenge.repositories.EstabilishmentRepository;
import com.fernando.fcamara1_backend_challenge.services.interfaces.EstabilishmentService;
import jakarta.persistence.EntityNotFoundException;
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
        Estabilishment estabilishment = estabilishmentRepository
        .findById(id)
        .orElseThrow(() -> 
        new EntityNotFoundException("Estabilishment is not exists"));
        
        return new EstabilishmentResponseDTO(id, estabilishment.getName(),
         estabilishment.getAddrees(), estabilishment.getTelephone(), 
        estabilishment.getQuantityMotocyclesVacancies(), 
        estabilishment.getQuantityCarsVacancies());
    }

    @Override
    public void delete(Long id) {
        estabilishmentRepository.deleteById(id);
    }

    @Override
    public void update(Long id, EstabilishmentRequestDTO requestDTO) {
        Estabilishment estabilishment = estabilishmentRepository
        .findById(id)
        .orElseThrow(() -> 
        new EntityNotFoundException("Estabilishment is not exists"));

        estabilishment.setName(requestDTO.getName());
        estabilishment.setCnpj(requestDTO.getCnpj());
        estabilishment.setAddrees(requestDTO.getAddrees());
        estabilishment.setQuantityCarsVacancies(requestDTO.getQuantityCarsVacancies());
        estabilishment.setQuantityMotocyclesVacancies(requestDTO.getQuantityMotocyclesVacancies());
        estabilishment.setTelephone(requestDTO.getTelephone());

        estabilishmentRepository.save(estabilishment);
    }

    @Override
    public List<EstabilishmentResponseDTO> findAll() {
        return estabilishmentRepository.findAll()
        .stream()
        .map(estabilishment -> 
        new EstabilishmentResponseDTO(estabilishment.getId(), 
        estabilishment.getName(), estabilishment.getAddrees(), 
        estabilishment.getTelephone(), 
        estabilishment.getQuantityMotocyclesVacancies(), 
        estabilishment.getQuantityCarsVacancies()))
        .toList();
    }

    @Override
    public List<VehicleResponseDTO> findByIDAllVehicles(Long estabilishmentID) {
        Estabilishment estabilishment = estabilishmentRepository
        .findById(estabilishmentID)
        .orElseThrow(() -> 
        new EntityNotFoundException("Estabilishment is not exists"));


        return estabilishment.getVehicles()
        .stream()
        .map(vehicle -> 
        new VehicleResponseDTO(vehicle.getId(), vehicle.getBrand(),
        vehicle.getModel(), vehicle.getColor(), vehicle.getPlate(),
        vehicle.getType().getValue().toLowerCase()))
        .toList();
    }
}
