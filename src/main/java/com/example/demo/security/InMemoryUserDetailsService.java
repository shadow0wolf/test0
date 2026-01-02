package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class InMemoryUserDetailsService implements UserDetailsService {

    // In-memory storage for users (username -> UserDetails)
    private final Map<String, UserDetails> users = new HashMap<>();

    public InMemoryUserDetailsService() {
        // Add sample users
        users.put("user1", User.builder()
                .username("user1")
                .password("{noop}password1") // {noop} means no password encoding
                .authorities("ROLE_USER")
                .build());

        users.put("admin", User.builder()
                .username("admin")
                .password("{noop}adminpass")
                .authorities("ROLE_ADMIN", "ROLE_USER")
                .build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return user;
    }
}
