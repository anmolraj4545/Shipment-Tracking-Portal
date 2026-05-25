package com.shipment_tracking.service;

import com.shipment_tracking.dto.AuthResponse;
import com.shipment_tracking.dto.RegisterRequest;

import com.shipment_tracking.entity.User;
import com.shipment_tracking.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService
{
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthResponse register(@Valid RegisterRequest request)
    {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(request.getRole())
                .createdAt(LocalDateTime.now())
                .build();

        user=userRepository.save(user);

        return AuthResponse.builder()
                .userId(user.getId())
                .fullName(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
