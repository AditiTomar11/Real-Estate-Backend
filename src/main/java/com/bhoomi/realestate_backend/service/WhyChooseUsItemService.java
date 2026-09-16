package com.bhoomi.realestate_backend.service;

import com.bhoomi.realestate_backend.dto.WhyChooseUsItemRequest;
import com.bhoomi.realestate_backend.entity.WhyChooseUsItem;
import com.bhoomi.realestate_backend.repository.WhyChooseUsItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WhyChooseUsItemService {

    private final WhyChooseUsItemRepository repository;

    public List<WhyChooseUsItem> getAll() {
        return repository.findAllByOrderByDisplayOrderAsc();
    }

    @Transactional
    public WhyChooseUsItem create(WhyChooseUsItemRequest request) {
        WhyChooseUsItem i = new WhyChooseUsItem();
        apply(i, request);
        return repository.save(i);
    }

    @Transactional
    public WhyChooseUsItem update(Long id, WhyChooseUsItemRequest request) {
        WhyChooseUsItem i = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found: " + id));
        apply(i, request);
        return repository.save(i);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(WhyChooseUsItem i, WhyChooseUsItemRequest r) {
        i.setIcon(r.getIcon());
        i.setTitle(r.getTitle());
        i.setDescription(r.getDescription());
        i.setDisplayOrder(r.getDisplayOrder());
    }
}