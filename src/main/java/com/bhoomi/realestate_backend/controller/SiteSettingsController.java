package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.entity.SiteSettings;
import com.bhoomi.realestate_backend.service.SiteSettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/site-settings")
@RequiredArgsConstructor
public class SiteSettingsController {

    private final SiteSettingsService service;

    @GetMapping
    public SiteSettings get() {
        return service.get();
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public SiteSettings update(@RequestBody SiteSettings settings) {
        return service.update(settings);
    }
}