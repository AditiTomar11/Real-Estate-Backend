package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.dto.PropertyRequest;
import com.bhoomi.realestate_backend.dto.PropertyResponse;
import com.bhoomi.realestate_backend.entity.Property;
import com.bhoomi.realestate_backend.entity.PropertyType;
import com.bhoomi.realestate_backend.service.PropertyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/properties")
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;

    // Matches ListingsPage's FilterPanel exactly: city, type, bhk, minPrice, maxPrice, query.
    @GetMapping
    public Page<PropertyResponse> search(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) PropertyType type,
            @RequestParam(required = false) Integer bhk,
            @RequestParam(required = false) Long minPrice,
            @RequestParam(required = false) Long maxPrice,
            @RequestParam(required = false) String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return propertyService.search(city, type, bhk, minPrice, maxPrice, query, pageable)
                .map(PropertyResponse::fromEntity);
    }
    @GetMapping("/{id}")
    public PropertyResponse getById(@PathVariable Long id) {
        return PropertyResponse.fromEntity(propertyService.getById(id));
    }

    @PostMapping("/compare")
    public List<PropertyResponse> compare(@RequestBody Map<String, List<Long>> body) {
        return propertyService.getByIds(body.get("ids")).stream()
                .map(PropertyResponse::fromEntity)
                .toList();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PropertyResponse> create(@Valid @RequestBody PropertyRequest request) {
        var created = propertyService.create(request);
        return ResponseEntity.ok(PropertyResponse.fromEntity((Property) created));
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public PropertyResponse update(@PathVariable Long id, @Valid @RequestBody PropertyRequest request) {
        return PropertyResponse.fromEntity((Property) propertyService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        propertyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
