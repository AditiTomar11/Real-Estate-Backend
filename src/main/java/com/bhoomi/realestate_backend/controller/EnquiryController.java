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
    // GET /api/enquiries (no email param at all) → admin inbox, enforced inside the service
    // The check is on the param being *present*, not non-blank: if the caller passes an
    // empty email we return that (empty) lookup result instead of falling into the
    // admin-inbox path and getting a 403.
    @GetMapping
    public List<EnquiryResponse> getAll(@RequestParam(required = false) String email) {
        if (email != null) {
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