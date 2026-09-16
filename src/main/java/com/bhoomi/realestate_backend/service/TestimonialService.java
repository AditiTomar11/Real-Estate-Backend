package com.bhoomi.realestate_backend.service;

import com.bhoomi.realestate_backend.dto.TestimonialRequest;
import com.bhoomi.realestate_backend.entity.Testimonial;
import com.bhoomi.realestate_backend.repository.TestimonialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestimonialService {

    private final TestimonialRepository repository;

    public List<Testimonial> getAll() {
        return repository.findAllByOrderByDisplayOrderAsc();
    }

    @Transactional
    public Testimonial create(TestimonialRequest request) {
        Testimonial t = new Testimonial();
        apply(t, request);
        return repository.save(t);
    }

    @Transactional
    public Testimonial update(Long id, TestimonialRequest request) {
        Testimonial t = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Testimonial not found: " + id));
        apply(t, request);
        return repository.save(t);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(Testimonial t, TestimonialRequest r) {
        t.setName(r.getName());
        t.setRole(r.getRole());
        t.setAvatarUrl(r.getAvatarUrl());
        t.setQuote(r.getQuote());
        t.setRating(r.getRating());
        t.setDisplayOrder(r.getDisplayOrder());
    }
}