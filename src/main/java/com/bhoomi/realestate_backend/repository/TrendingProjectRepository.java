package com.bhoomi.realestate_backend.repository;

import com.bhoomi.realestate_backend.entity.TrendingProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrendingProjectRepository extends JpaRepository<TrendingProject, Long> {
    List<TrendingProject> findAllByOrderByDisplayOrderAsc();
}