package com.fernando.fcamara1_backend_challenge.repositories;

import com.fernando.fcamara1_backend_challenge.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}