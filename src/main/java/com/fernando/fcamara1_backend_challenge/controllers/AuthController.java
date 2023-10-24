package com.fernando.fcamara1_backend_challenge.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    public ResponseEntity<?> login() {
        return ResponseEntity.noContent().build();
    }
}