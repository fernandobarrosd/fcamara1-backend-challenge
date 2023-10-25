package com.fernando.fcamara1_backend_challenge.services.interfaces;

import com.fernando.fcamara1_backend_challenge.dtos.auth.LoginRequestDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    String login(LoginRequestDTO loginRequestDTO);
}