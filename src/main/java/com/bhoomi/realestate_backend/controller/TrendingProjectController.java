package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.dto.TrendingProjectRequest;
import com.bhoomi.realestate_backend.dto.TrendingProjectResponse;
import com.bhoomi.realestate_backend.service.TrendingProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trending-projects")
@RequiredArgsConstructor
public class TrendingProjectController {

    private final TrendingProjectService service;

    @GetMapping
    public List<TrendingProjectResponse> getAll() {
        return service.getAll().stream().map(TrendingProjectResponse::fromEntity).toList();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public TrendingProjectResponse create(@Valid @RequestBody TrendingProjectRequest request) {
        return TrendingProjectResponse.fromEntity(service.create(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public TrendingProjectResponse update(@PathVariable Long id, @Valid @RequestBody TrendingProjectRequest request) {
        return TrendingProjectResponse.fromEntity(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}