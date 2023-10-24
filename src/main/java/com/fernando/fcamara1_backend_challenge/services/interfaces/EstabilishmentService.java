package com.fernando.fcamara1_backend_challenge.services.interfaces;

import java.util.List;

import com.fernando.fcamara1_backend_challenge.dtos.estabilishment.EstabilishmentRequestDTO;
import com.fernando.fcamara1_backend_challenge.dtos.estabilishment.EstabilishmentResponseDTO;
import com.fernando.fcamara1_backend_challenge.dtos.vehicle.VehicleResponseDTO;

public interface EstabilishmentService extends CrudService<EstabilishmentRequestDTO, EstabilishmentResponseDTO>{
    List<VehicleResponseDTO> findByIDAllVehicles(Long estabilishmentID);
}