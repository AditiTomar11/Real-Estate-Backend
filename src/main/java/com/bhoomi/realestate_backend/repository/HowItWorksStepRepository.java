package com.bhoomi.realestate_backend.repository;

import com.bhoomi.realestate_backend.entity.HowItWorksStep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HowItWorksStepRepository extends JpaRepository<HowItWorksStep, Long> {
    List<HowItWorksStep> findAllByOrderByDisplayOrderAsc();
}