package com.bhoomi.realestate_backend.service;

import com.bhoomi.realestate_backend.dto.HowItWorksStepRequest;
import com.bhoomi.realestate_backend.entity.HowItWorksStep;
import com.bhoomi.realestate_backend.repository.HowItWorksStepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HowItWorksStepService {

    private final HowItWorksStepRepository repository;

    public List<HowItWorksStep> getAll() {
        return repository.findAllByOrderByDisplayOrderAsc();
    }

    @Transactional
    public HowItWorksStep create(HowItWorksStepRequest request) {
        HowItWorksStep s = new HowItWorksStep();
        apply(s, request);
        return repository.save(s);
    }

    @Transactional
    public HowItWorksStep update(Long id, HowItWorksStepRequest request) {
        HowItWorksStep s = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Step not found: " + id));
        apply(s, request);
        return repository.save(s);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(HowItWorksStep s, HowItWorksStepRequest r) {
        s.setStepLabel(r.getStepLabel());
        s.setIcon(r.getIcon());
        s.setTitle(r.getTitle());
        s.setDescription(r.getDescription());
        s.setDisplayOrder(r.getDisplayOrder());
    }
}