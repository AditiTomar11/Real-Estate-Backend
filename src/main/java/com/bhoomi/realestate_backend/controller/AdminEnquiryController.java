package com.bhoomi.realestate_backend.controller;

import com.bhoomi.realestate_backend.dto.EnquiryReplyRequest;
import com.bhoomi.realestate_backend.dto.EnquiryReplyResponse;
import com.bhoomi.realestate_backend.service.EnquiryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/enquiries")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminEnquiryController {

    private final EnquiryService enquiryService;

    @PostMapping("/{id}/replies")
    public EnquiryReplyResponse reply(@PathVariable Long id, @Valid @RequestBody EnquiryReplyRequest request) {
        return enquiryService.addReply(id, request);
    }
}