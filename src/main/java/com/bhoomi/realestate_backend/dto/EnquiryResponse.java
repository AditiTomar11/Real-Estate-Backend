package com.bhoomi.realestate_backend.dto;

import com.bhoomi.realestate_backend.entity.Enquiry;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private LocalDateTime createdAt;

    public static EnquiryResponse fromEntity(Enquiry e) {
        EnquiryResponse r = new EnquiryResponse();
        r.setId(e.getId());
        r.setPropertyId(e.getProperty().getId());
        r.setPropertyTitle(e.getProperty().getTitle());
        r.setName(e.getName());
        r.setPhone(e.getPhone());
        r.setEmail(e.getEmail());
        r.setMessage(e.getMessage());
        r.setCreatedAt(e.getCreatedAt());
        return r;
    }
}