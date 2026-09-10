package com.bhoomi.realestate_backend.service;

import com.bhoomi.realestate_backend.entity.SiteSettings;
import com.bhoomi.realestate_backend.repository.SiteSettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SiteSettingsService {

    private final SiteSettingsRepository repository;

    public SiteSettings get() {
        return repository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Site settings not seeded yet"));
    }

    @Transactional
    public SiteSettings update(SiteSettings incoming) {
        incoming.setId(1L); // always overwrite the single row, never create a second one
        return repository.save(incoming);
    }
}