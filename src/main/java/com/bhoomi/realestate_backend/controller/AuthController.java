package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.dto.AuthResponse;
import com.bhoomi.realestate_backend.dto.LoginRequest;
import com.bhoomi.realestate_backend.dto.RegisterRequest;
import com.bhoomi.realestate_backend.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }

    // Returns the profile of whoever's token is on the request.
    // Requires a valid token — /api/auth/me is NOT in the permitAll list,
    // which is deliberate: an anonymous caller has no profile to return.
    @GetMapping("/me")
    public AuthResponse.UserInfo me() {
        return authService.getCurrentUser();
    }
}
