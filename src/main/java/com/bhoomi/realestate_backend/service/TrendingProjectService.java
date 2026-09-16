package com.bhoomi.realestate_backend.service;

import com.bhoomi.realestate_backend.dto.TrendingProjectRequest;
import com.bhoomi.realestate_backend.entity.TrendingProject;
import com.bhoomi.realestate_backend.repository.TrendingProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrendingProjectService {

    private final TrendingProjectRepository repository;

    public List<TrendingProject> getAll() {
        return repository.findAllByOrderByDisplayOrderAsc();
    }

    @Transactional
    public TrendingProject create(TrendingProjectRequest request) {
        TrendingProject p = new TrendingProject();
        apply(p, request);
        return repository.save(p);
    }

    @Transactional
    public TrendingProject update(Long id, TrendingProjectRequest request) {
        TrendingProject p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trending project not found: " + id));
        apply(p, request);
        return repository.save(p);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(TrendingProject p, TrendingProjectRequest r) {
        p.setName(r.getName());
        p.setBuilder(r.getBuilder());
        p.setLocation(r.getLocation());
        p.setType(r.getType());
        p.setArea(r.getArea());
        p.setPrice(r.getPrice());
        p.setImageUrl(r.getImageUrl());
        p.setNew(r.isNew());
        p.setDisplayOrder(r.getDisplayOrder());
    }
}