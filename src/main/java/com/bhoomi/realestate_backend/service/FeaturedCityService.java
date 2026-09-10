package com.bhoomi.realestate_backend.service;

import com.bhoomi.realestate_backend.dto.FeaturedCityRequest;
import com.bhoomi.realestate_backend.entity.FeaturedCity;
import com.bhoomi.realestate_backend.repository.FeaturedCityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeaturedCityService {

    private final FeaturedCityRepository repository;

    public List<FeaturedCity> getAll() {
        return repository.findAllByOrderByDisplayOrderAsc();
    }

    @Transactional
    public FeaturedCity create(FeaturedCityRequest request) {
        FeaturedCity c = new FeaturedCity();
        apply(c, request);
        return repository.save(c);
    }

    @Transactional
    public FeaturedCity update(Long id, FeaturedCityRequest request) {
        FeaturedCity c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Featured city not found: " + id));
        apply(c, request);
        return repository.save(c);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(FeaturedCity c, FeaturedCityRequest r) {
        c.setName(r.getName());
        c.setOptionsCount(r.getOptionsCount());
        c.setImageUrl(r.getImageUrl());
        c.setDisplayOrder(r.getDisplayOrder());
    }
}