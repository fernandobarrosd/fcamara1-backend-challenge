package com.fernando.fcamara1_backend_challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fernando.fcamara1_backend_challenge.dtos.vehicle.VehicleRequestDTO;
import com.fernando.fcamara1_backend_challenge.services.interfaces.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> findAllVehicles() {
        return ResponseEntity.ok().body(vehicleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok().body(vehicleService.findByID(id));
    }

    @PostMapping
    public ResponseEntity<?> saveVehicle(@RequestBody VehicleRequestDTO requestDTO) {
        vehicleService.save(requestDTO);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable Long id, @RequestBody VehicleRequestDTO requestDTO) {
        vehicleService.update(id, requestDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{vehicleID}/entry/{estabilishmentID}")
    public ResponseEntity<?> entryVehicleToEstabilishemnt(@PathVariable Long vehicleID, @PathVariable Long estabilishmentID) {
        vehicleService.entryToEstabilishment(estabilishmentID, vehicleID);
        return ResponseEntity.noContent().build();
    }

     @PostMapping("/{vehicleID}/exit/{estabilishmentID}")
    public ResponseEntity<?> exitVehicleToEstabilishemnt(@PathVariable Long vehicleID, @PathVariable Long estabilishmentID) {
        vehicleService.exitToEstabilishment(estabilishmentID, vehicleID);
        return ResponseEntity.noContent().build();
    }
}
