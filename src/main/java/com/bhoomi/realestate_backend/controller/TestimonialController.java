package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.dto.TestimonialRequest;
import com.bhoomi.realestate_backend.dto.TestimonialResponse;
import com.bhoomi.realestate_backend.service.TestimonialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
@RequiredArgsConstructor
public class TestimonialController {

    private final TestimonialService service;

    @GetMapping
    public List<TestimonialResponse> getAll() {
        return service.getAll().stream().map(TestimonialResponse::fromEntity).toList();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public TestimonialResponse create(@Valid @RequestBody TestimonialRequest request) {
        return TestimonialResponse.fromEntity(service.create(request));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public TestimonialResponse update(@PathVariable Long id, @Valid @RequestBody TestimonialRequest request) {
        return TestimonialResponse.fromEntity(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}