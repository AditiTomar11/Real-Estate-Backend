package com.bhoomi.realestate_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HowItWorksStepRequest {
    @NotBlank private String stepLabel;
    @NotBlank private String icon;
    @NotBlank private String title;
    @NotBlank private String description;
    private Integer displayOrder = 0;
}