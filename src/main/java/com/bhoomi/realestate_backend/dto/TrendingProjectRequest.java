package com.bhoomi.realestate_backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrendingProjectRequest {
    @NotBlank private String name;
    @NotBlank private String builder;
    @NotBlank private String location;
    @NotBlank private String type;
    @NotBlank private String area;
    @NotBlank private String price;
    @NotBlank private String imageUrl;
    private boolean isNew;
    private Integer displayOrder = 0;
}