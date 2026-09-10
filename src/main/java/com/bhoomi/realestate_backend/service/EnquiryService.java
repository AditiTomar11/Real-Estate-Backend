package com.bhoomi.realestate_backend.service;

import com.bhoomi.realestate_backend.dto.EnquiryRequest;
import com.bhoomi.realestate_backend.dto.EnquiryResponse;
import com.bhoomi.realestate_backend.entity.Enquiry;
import com.bhoomi.realestate_backend.entity.Property;
import com.bhoomi.realestate_backend.repository.EnquiryRepository;
import com.bhoomi.realestate_backend.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnquiryService {

    private final EnquiryRepository enquiryRepository;
    private final PropertyRepository propertyRepository;

    @Transactional
    public void submit(EnquiryRequest request) {
        Property property = propertyRepository.findById(request.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found: " + request.getPropertyId()));

        Enquiry enquiry = new Enquiry();
        enquiry.setProperty(property);
        enquiry.setName(request.getName());
        enquiry.setPhone(request.getPhone());
        enquiry.setEmail(request.getEmail());
        enquiry.setMessage(request.getMessage());
        // user left null — enquiries are allowed from guests, not just logged-in users
        enquiryRepository.save(enquiry);
    }
    public List<EnquiryResponse> getAll() {
        return enquiryRepository.findAll().stream()
                .map(EnquiryResponse::fromEntity)
                .toList();
    }
}