package com.bhoomi.realestate_backend.service;

import com.bhoomi.realestate_backend.dto.*;
import com.bhoomi.realestate_backend.entity.*;
import com.bhoomi.realestate_backend.repository.EnquiryReplyRepository;
import com.bhoomi.realestate_backend.repository.EnquiryRepository;
import com.bhoomi.realestate_backend.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
public class EnquiryService {

    private final EnquiryRepository enquiryRepository;
    private final EnquiryReplyRepository replyRepository;
    private final PropertyRepository propertyRepository;

    @Transactional
    public void submit(EnquiryRequest request) {
        Property property = null;
        if (request.getPropertyId() != null) {
            property = propertyRepository.findById(request.getPropertyId())
                    .orElseThrow(() -> new RuntimeException("Property not found: " + request.getPropertyId()));
        }

        Enquiry enquiry = new Enquiry();
        enquiry.setProperty(property);
        enquiry.setName(request.getName());
        enquiry.setPhone(request.getPhone());
        enquiry.setEmail(request.getEmail());
        enquiry.setMessage(request.getMessage());
        enquiry.setStatus(EnquiryStatus.NEW);
        enquiryRepository.save(enquiry);
    }

    public List<EnquiryResponse> getAllAdminOnly() {
        var auth = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = auth != null && auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        if (!isAdmin) {
            throw new org.springframework.security.access.AccessDeniedException("Admin access required");
        }
        return enquiryRepository.findAll().stream()
                .map(this::toResponseWithReplies)
                .toList();
    }

    public EnquiryResponse getById(Long id) {
        Enquiry enquiry = enquiryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enquiry not found: " + id));
        return toResponseWithReplies(enquiry);
    }

    public List<EnquiryResponse> getByEmail(String email) {
        return enquiryRepository.findByEmail(email).stream()
                .map(this::toResponseWithReplies)
                .toList();
    }

    // Reply gets saved in the DB, but no email is sent — sentViaEmail stays false.
    // When email is added later, only this method needs to change.
    @Transactional
    public EnquiryReplyResponse addReply(Long enquiryId, EnquiryReplyRequest request) {
        Enquiry enquiry = enquiryRepository.findById(enquiryId)
                .orElseThrow(() -> new RuntimeException("Enquiry not found: " + enquiryId));

        EnquiryReply reply = new EnquiryReply();
        reply.setEnquiry(enquiry);
        reply.setSender("ADMIN");
        reply.setMessage(request.getMessage());
        reply.setSentViaEmail(false);
        replyRepository.save(reply);

        enquiry.setStatus(EnquiryStatus.REPLIED);
        enquiryRepository.save(enquiry);

        return EnquiryReplyResponse.fromEntity(reply);
    }

    private EnquiryResponse toResponseWithReplies(Enquiry enquiry) {
        List<EnquiryReplyResponse> replies = replyRepository
                .findByEnquiryIdOrderByCreatedAtAsc(enquiry.getId()).stream()
                .map(EnquiryReplyResponse::fromEntity)
                .toList();
        return EnquiryResponse.fromEntity(enquiry, replies);
    }
}