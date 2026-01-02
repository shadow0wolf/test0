package com.example.demo.Controller;

import com.example.demo.security.InMemoryUserDetailsService;
import com.example.demo.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    record LoginRequest(String username, String password) {};
    @Autowired
    JwtService jwtService;
    @Autowired
    InMemoryUserDetailsService inMemoryUserDetailsService;

    @PostMapping("/public/auth/login")
    public ResponseEntity<Map> login(@RequestBody  LoginRequest loginRequest) {
         if ("user1".equals(loginRequest.username) && "password1".equals(loginRequest.password)) {
                UserDetails userDetails = inMemoryUserDetailsService.loadUserByUsername(loginRequest.username);
                String token = jwtService.generateToken(userDetails);
                HashMap<String, String> mapx = new HashMap<>();
                mapx.put("token", token);
                return ResponseEntity.ok(mapx);
         }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
}
