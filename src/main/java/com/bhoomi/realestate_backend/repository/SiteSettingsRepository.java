package com.bhoomi.realestate_backend.repository;

import com.bhoomi.realestate_backend.entity.SiteSettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteSettingsRepository extends JpaRepository<SiteSettings, Long> {
}