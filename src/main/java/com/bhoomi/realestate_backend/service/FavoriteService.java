package com.bhoomi.realestate_backend.service;

import com.bhoomi.realestate_backend.dto.PropertyResponse;
import com.bhoomi.realestate_backend.entity.Favorite;
import com.bhoomi.realestate_backend.entity.Property;
import com.bhoomi.realestate_backend.entity.User;
import com.bhoomi.realestate_backend.repository.FavoriteRepository;
import com.bhoomi.realestate_backend.repository.PropertyRepository;
import com.bhoomi.realestate_backend.repository.UserRepository;
import com.bhoomi.realestate_backend.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    private User currentUser() {
        String email = SecurityUtil.getCurrentUserEmail();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found: " + email));
    }

    public List<PropertyResponse> getMyFavorites() {
        User user = currentUser();
        return favoriteRepository.findByUserId(user.getId()).stream()
                .map(fav -> PropertyResponse.fromEntity(fav.getProperty()))
                .toList();
    }

    @Transactional
    public void addFavorite(Long propertyId) {
        User user = currentUser();

        if (favoriteRepository.existsByUserIdAndPropertyId(user.getId(), propertyId)) {
            return; // already favorited — nothing to do, keeps the endpoint idempotent
        }

        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found: " + propertyId));

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setProperty(property);
        favoriteRepository.save(favorite);
    }

    @Transactional
    public void removeFavorite(Long propertyId) {
        User user = currentUser();
        favoriteRepository.findByUserIdAndPropertyId(user.getId(), propertyId)
                .ifPresent(favoriteRepository::delete);
    }
}