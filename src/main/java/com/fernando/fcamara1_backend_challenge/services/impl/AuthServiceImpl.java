package com.fernando.fcamara1_backend_challenge.services.impl;

import com.fernando.fcamara1_backend_challenge.dtos.auth.LoginRequestDTO;
import com.fernando.fcamara1_backend_challenge.entities.User;
import com.fernando.fcamara1_backend_challenge.repositories.UserRepository;
import com.fernando.fcamara1_backend_challenge.services.interfaces.AuthService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService  {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String login(LoginRequestDTO requestDTO) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(requestDTO.getUsername(),
                        requestDTO.getPassword());


        return "";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User is not exists!"));
    }
}
