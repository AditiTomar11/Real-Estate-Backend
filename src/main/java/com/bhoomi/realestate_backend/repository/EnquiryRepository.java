package com.bhoomi.realestate_backend.repository;

import com.bhoomi.realestate_backend.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
    List<Enquiry> findByEmail(String email);
}