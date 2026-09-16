package com.bhoomi.realestate_backend.repository;

import com.bhoomi.realestate_backend.entity.WhyChooseUsItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhyChooseUsItemRepository extends JpaRepository<WhyChooseUsItem, Long> {
    List<WhyChooseUsItem> findAllByOrderByDisplayOrderAsc();
}