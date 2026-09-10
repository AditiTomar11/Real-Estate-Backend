package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.dto.FeaturedCityRequest;
import com.bhoomi.realestate_backend.dto.FeaturedCityResponse;
import com.bhoomi.realestate_backend.service.FeaturedCityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/featured-cities")
@RequiredArgsConstructor
public class FeaturedCityController {

    private final FeaturedCityService service;

    @GetMapping
    public List<FeaturedCityResponse> getAll() {
        return service.getAll().stream().map(FeaturedCityResponse::fromEntity).toList();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public FeaturedCityResponse create(@Valid @RequestBody FeaturedCityRequest request) {
        return FeaturedCityResponse.fromEntity(service.create(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public FeaturedCityResponse update(@PathVariable Long id, @Valid @RequestBody FeaturedCityRequest request) {
        return FeaturedCityResponse.fromEntity(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}