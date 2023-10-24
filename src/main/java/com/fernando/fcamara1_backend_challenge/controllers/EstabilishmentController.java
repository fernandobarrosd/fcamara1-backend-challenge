package com.fernando.fcamara1_backend_challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fernando.fcamara1_backend_challenge.dtos.estabilishment.EstabilishmentRequestDTO;
import com.fernando.fcamara1_backend_challenge.services.interfaces.EstabilishmentService;

@RestController
@RequestMapping("/estabilishments")
public class EstabilishmentController {
    @Autowired
    private EstabilishmentService estabilishmentService;
    
    @GetMapping
    public ResponseEntity<?> findAllEstabilishments() {
        return ResponseEntity.ok().body(estabilishmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findEstabilishmentByID(@PathVariable Long id) {
        return ResponseEntity.ok().body(estabilishmentService.findByID(id));
    }

    @PostMapping
    public ResponseEntity<?> saveEstabilishment(@RequestBody EstabilishmentRequestDTO requestDTO) {
        estabilishmentService.save(requestDTO);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateEstabilishment(@PathVariable Long id, @RequestBody EstabilishmentRequestDTO requestDTO) {
        estabilishmentService.update(id, requestDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEstabilishment(@PathVariable Long id) {
        estabilishmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{estabilishmentID}/vehicles")
    public ResponseEntity<?> findByIDAllVehicles(@PathVariable Long estabilishmentID) {
        return ResponseEntity.ok().body(estabilishmentService.findByIDAllVehicles(estabilishmentID));
    } 
}