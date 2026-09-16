package com.bhoomi.realestate_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeaturedCityRequest {
    @NotBlank private String name;
    @NotBlank private String optionsCount;
    @NotBlank private String imageUrl;
    private Integer displayOrder = 0;
}