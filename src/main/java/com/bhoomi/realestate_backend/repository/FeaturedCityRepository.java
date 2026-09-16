package com.bhoomi.realestate_backend.repository;

import com.bhoomi.realestate_backend.entity.FeaturedCity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeaturedCityRepository extends JpaRepository<FeaturedCity, Long> {
    List<FeaturedCity> findAllByOrderByDisplayOrderAsc();
}