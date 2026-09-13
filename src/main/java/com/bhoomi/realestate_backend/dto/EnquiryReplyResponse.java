package com.bhoomi.realestate_backend.dto;

import com.bhoomi.realestate_backend.entity.EnquiryReply;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EnquiryReplyResponse {
    private Long id;
    private String sender;
    private String message;
    private LocalDateTime createdAt;
    private boolean sentViaEmail;

    public static EnquiryReplyResponse fromEntity(EnquiryReply r) {
        EnquiryReplyResponse dto = new EnquiryReplyResponse();
        dto.setId(r.getId());
        dto.setSender(r.getSender());
        dto.setMessage(r.getMessage());
        dto.setCreatedAt(r.getCreatedAt());
        dto.setSentViaEmail(r.isSentViaEmail());
        return dto;
    }
}