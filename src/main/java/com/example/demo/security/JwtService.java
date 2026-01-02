package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;


public interface JwtService {

    // Generates JWT for authenticated user
    String generateToken(UserDetails userDetails);

    // Extracts username from token
    String extractUsername(String token);

    // Validates token integrity and expiration
    boolean isTokenValid(String token);
}