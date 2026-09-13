package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.dto.EnquiryRequest;
import com.bhoomi.realestate_backend.dto.EnquiryResponse;
import com.bhoomi.realestate_backend.service.EnquiryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enquiries")
@RequiredArgsConstructor
public class EnquiryController {

    private final EnquiryService enquiryService;

    @PostMapping
    public ResponseEntity<Void> submit(@Valid @RequestBody EnquiryRequest request) {
        enquiryService.submit(request);
        return ResponseEntity.ok().build();
    }

    // GET /api/enquiries?email=... → self-service lookup (public, no auth)
    // GET /api/enquiries (no param) → admin inbox, enforced inside the service
    @GetMapping
    public List<EnquiryResponse> getAll(@RequestParam(required = false) String email) {
        if (email != null && !email.isBlank()) {
            return enquiryService.getByEmail(email);
        }
        return enquiryService.getAllAdminOnly();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public EnquiryResponse getById(@PathVariable Long id) {
        return enquiryService.getById(id);
    }
}