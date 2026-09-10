package com.bhoomi.realestate_backend.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestimonialRequest {
    @NotBlank private String name;
    @NotBlank private String role;
    @NotBlank private String avatarUrl;
    @NotBlank private String quote;
    @Min(1) @Max(5) private Integer rating = 5;
    private Integer displayOrder = 0;
}