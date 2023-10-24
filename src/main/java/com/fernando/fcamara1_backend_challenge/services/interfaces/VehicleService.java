package com.fernando.fcamara1_backend_challenge.services.interfaces;

import com.fernando.fcamara1_backend_challenge.dtos.vehicle.VehicleRequestDTO;
import com.fernando.fcamara1_backend_challenge.dtos.vehicle.VehicleResponseDTO;

public interface VehicleService extends CrudService<VehicleRequestDTO, VehicleResponseDTO>{
    void entryToEstabilishment(Long estabilishmentID, Long vehicleID);
    void exitToEstabilishment(Long estabilishmentID, Long vehicleID);
}