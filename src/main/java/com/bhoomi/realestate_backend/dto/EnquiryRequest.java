package com.bhoomi.realestate_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnquiryRequest {

    @NotNull
    private Long propertyId;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    private String email;

    private String message;
}