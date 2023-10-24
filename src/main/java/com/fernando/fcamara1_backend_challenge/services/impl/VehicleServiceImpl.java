package com.fernando.fcamara1_backend_challenge.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fernando.fcamara1_backend_challenge.dtos.estabilishment.EstabilishmentResponseDTO;
import com.fernando.fcamara1_backend_challenge.dtos.vehicle.VehicleRequestDTO;
import com.fernando.fcamara1_backend_challenge.dtos.vehicle.VehicleResponseDTO;
import com.fernando.fcamara1_backend_challenge.entities.Estabilishment;
import com.fernando.fcamara1_backend_challenge.entities.Vehicle;
import com.fernando.fcamara1_backend_challenge.enums.VehicleType;
import com.fernando.fcamara1_backend_challenge.repositories.EstabilishmentRepository;
import com.fernando.fcamara1_backend_challenge.repositories.VehicleRepository;
import com.fernando.fcamara1_backend_challenge.services.interfaces.EstabilishmentService;
import com.fernando.fcamara1_backend_challenge.services.interfaces.VehicleService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private EstabilishmentRepository estabilishmentRepository;

    @Override
    public void save(VehicleRequestDTO requestDTO) {
       Vehicle vehicle = new Vehicle();
       vehicle.setBrand(requestDTO.getBrand());
       vehicle.setColor(requestDTO.getColor());
       vehicle.setModel(requestDTO.getModel());
       vehicle.setPlate(requestDTO.getPlate());

       if (requestDTO.getType().equals("car")) {
        vehicle.setType(VehicleType.CAR);
       }
       else if (requestDTO.getType().equals("motocyle")) {
        vehicle.setType(VehicleType.MOTOCYCLE);
       }

       vehicleRepository.save(vehicle);
    }

    @Override
    public VehicleResponseDTO findByID(Long id) {
        Vehicle vehicle = vehicleRepository
        .findById(id)
        .orElseThrow(() -> 
        new EntityNotFoundException("Vehicle is not exists"));

        return new VehicleResponseDTO(id, vehicle.getBrand(), 
        vehicle.getModel(), vehicle.getColor(), vehicle.getPlate(), 
        vehicle.getType().getValue().toLowerCase());
    }

    @Override
    public List<VehicleResponseDTO> findAll() {
        return vehicleRepository.findAll()
        .stream()
        .map(vehicle -> 
        new VehicleResponseDTO(vehicle.getId(), vehicle.getBrand(), 
        vehicle.getModel(), vehicle.getColor(), vehicle.getPlate(), 
        vehicle.getType().getValue().toLowerCase()))
        .toList();
    }

    @Override
    public void delete(Long id) {
       vehicleRepository.deleteById(id);
    }

    @Override
    public void update(Long id, VehicleRequestDTO requestDTO) {
        Vehicle vehicle = vehicleRepository
        .findById(id)
        .orElseThrow(() -> 
        new EntityNotFoundException("Vehicle is not exists"));

        vehicle.setBrand(requestDTO.getBrand());
        vehicle.setColor(requestDTO.getColor());
        vehicle.setModel(requestDTO.getModel());
        vehicle.setPlate(requestDTO.getPlate());

        if (requestDTO.getType() == "car") {
            vehicle.setType(VehicleType.CAR);
        }
        else if (requestDTO.getType() == "motocyle") {
            vehicle.setType(VehicleType.MOTOCYCLE);
        }

        vehicleRepository.save(vehicle);
    }

    @Override
    public void entryToEstabilishment(Long estabilishmentID, Long vehicleID) {
        Estabilishment estabilishment = estabilishmentRepository
        .findById(estabilishmentID)
        .orElseThrow(() -> 
        new EntityNotFoundException("Estabilishment is not exists"));

        Vehicle vehicle = vehicleRepository
        .findById(vehicleID)
        .orElseThrow(() -> 
        new EntityNotFoundException("Vehicle is not exists"));

        estabilishment.getVehicles().add(vehicle);

        estabilishmentRepository.save(estabilishment);

        
    }

    @Override
    public void exitToEstabilishment(Long estabilishmentID, Long vehicleID) {
        Estabilishment estabilishment = estabilishmentRepository
        .findById(estabilishmentID)
        .orElseThrow(() -> 
        new EntityNotFoundException("Estabilishment is not exists"));

        Vehicle vehicle = vehicleRepository
        .findById(vehicleID)
        .orElseThrow(() -> 
        new EntityNotFoundException("Vehicle is not exists"));

        estabilishment.getVehicles().remove(vehicle);

        estabilishmentRepository.save(estabilishment);
    }
    
}
