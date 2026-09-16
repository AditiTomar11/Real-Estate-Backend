package com.bhoomi.realestate_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnquiryReplyRequest {
    @NotBlank
    private String message;
}