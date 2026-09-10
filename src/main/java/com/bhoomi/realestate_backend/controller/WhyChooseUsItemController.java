package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.dto.WhyChooseUsItemRequest;
import com.bhoomi.realestate_backend.dto.WhyChooseUsItemResponse;
import com.bhoomi.realestate_backend.service.WhyChooseUsItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/why-choose-us")
@RequiredArgsConstructor
public class WhyChooseUsItemController {

    private final WhyChooseUsItemService service;

    @GetMapping
    public List<WhyChooseUsItemResponse> getAll() {
        return service.getAll().stream().map(WhyChooseUsItemResponse::fromEntity).toList();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public WhyChooseUsItemResponse create(@Valid @RequestBody WhyChooseUsItemRequest request) {
        return WhyChooseUsItemResponse.fromEntity(service.create(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public WhyChooseUsItemResponse update(@PathVariable Long id, @Valid @RequestBody WhyChooseUsItemRequest request) {
        return WhyChooseUsItemResponse.fromEntity(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}