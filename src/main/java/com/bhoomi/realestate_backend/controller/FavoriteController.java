package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.dto.FavoriteRequest;
import com.bhoomi.realestate_backend.dto.PropertyResponse;
import com.bhoomi.realestate_backend.service.FavoriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @GetMapping
    public List<PropertyResponse> getMyFavorites() {
        return favoriteService.getMyFavorites();
    }

    @PostMapping
    public ResponseEntity<Void> addFavorite(@Valid @RequestBody FavoriteRequest request) {
        favoriteService.addFavorite(request.getPropertyId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{propertyId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Long propertyId) {
        favoriteService.removeFavorite(propertyId);
        return ResponseEntity.noContent().build();
    }
}