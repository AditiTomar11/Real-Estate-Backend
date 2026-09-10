package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.dto.HowItWorksStepRequest;
import com.bhoomi.realestate_backend.dto.HowItWorksStepResponse;
import com.bhoomi.realestate_backend.service.HowItWorksStepService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/how-it-works")
@RequiredArgsConstructor
public class HowItWorksStepController {

    private final HowItWorksStepService service;

    @GetMapping
    public List<HowItWorksStepResponse> getAll() {
        return service.getAll().stream().map(HowItWorksStepResponse::fromEntity).toList();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public HowItWorksStepResponse create(@Valid @RequestBody HowItWorksStepRequest request) {
        return HowItWorksStepResponse.fromEntity(service.create(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public HowItWorksStepResponse update(@PathVariable Long id, @Valid @RequestBody HowItWorksStepRequest request) {
        return HowItWorksStepResponse.fromEntity(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}