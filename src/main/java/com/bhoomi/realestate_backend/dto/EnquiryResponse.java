package com.bhoomi.realestate_backend.dto;

import com.bhoomi.realestate_backend.entity.Enquiry;
import com.bhoomi.realestate_backend.entity.EnquiryStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
public class EnquiryResponse {
    private Long id;
    private Long propertyId;
    private String propertyTitle;
    private String name;
    private String phone;
    private String email;
    private String message;
    private EnquiryStatus status;
    private LocalDateTime createdAt;
    private List<EnquiryReplyResponse> replies;

    public static EnquiryResponse fromEntity(Enquiry e, List<EnquiryReplyResponse> replies) {
        EnquiryResponse r = new EnquiryResponse();
        r.setId(e.getId());
        if (e.getProperty() != null) {
            r.setPropertyId(e.getProperty().getId());
            r.setPropertyTitle(e.getProperty().getTitle());
        } else {
            r.setPropertyTitle("General enquiry");
        }
        r.setName(e.getName());
        r.setPhone(e.getPhone());
        r.setEmail(e.getEmail());
        r.setMessage(e.getMessage());
        r.setStatus(e.getStatus());
        r.setCreatedAt(e.getCreatedAt());
        r.setReplies(replies);
        return r;
    }
}