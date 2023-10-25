package com.fernando.fcamara1_backend_challenge.controllers;

import com.fernando.fcamara1_backend_challenge.dtos.auth.LoginRequestDTO;
import com.fernando.fcamara1_backend_challenge.services.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO requestDTO) {
        String token = authService.login(requestDTO);
        return ResponseEntity.ok().body(token);
    }
}