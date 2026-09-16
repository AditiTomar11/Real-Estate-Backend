package com.bhoomi.realestate_backend.service;

import com.bhoomi.realestate_backend.dto.PropertyRequest;
import com.bhoomi.realestate_backend.entity.Property;
import com.bhoomi.realestate_backend.repository.PropertyRepository;
import com.bhoomi.realestate_backend.specification.PropertySpecification;
import com.bhoomi.realestate_backend.entity.PropertyType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public Page<Property> search(String city, PropertyType type, Integer bhk,
                                 Long minPrice, Long maxPrice, String query,
                                 Pageable pageable) {
        var spec = PropertySpecification.withFilters(city, type, bhk, minPrice, maxPrice, query);
        return propertyRepository.findAll(spec, pageable);
    }

    public Property getById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found: " + id));
    }

    public List<Property> getByIds(List<Long> ids) {
        return propertyRepository.findByIdIn(ids);
    }

    @Transactional
    public Property create(PropertyRequest request) {
        Property property = new Property();
        applyRequest(property, request);
        return propertyRepository.save(property);
    }

    @Transactional
    public Property update(Long id, PropertyRequest request) {
        Property property = getById(id);
        applyRequest(property, request);
        return propertyRepository.save(property);
    }

    @Transactional
    public void delete(Long id) {
        propertyRepository.deleteById(id);
    }

    private void applyRequest(Property property, PropertyRequest request) {
        property.setTitle(request.getTitle());
        property.setCity(request.getCity());
        property.setLocality(request.getLocality());
        property.setType(request.getType());
        property.setBhk(request.getBhk());
        property.setPrice(request.getPrice());
        property.setAreaSqft(request.getAreaSqft());
        property.setStatus(request.getStatus());
        property.setDescription(request.getDescription());
        property.setImages(request.getImages());
    }
}