package com.bhoomi.realestate_backend.dto;


import com.bhoomi.realestate_backend.entity.PropertyStatus;
import com.bhoomi.realestate_backend.entity.PropertyType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PropertyRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String city;

    @NotBlank
    private String locality;

    @NotNull
    private PropertyType type;

    private Integer bhk = 0;

    @NotNull
    private Long price;

    @NotNull
    private Integer areaSqft;

    private PropertyStatus status = PropertyStatus.AVAILABLE;

    private String description;

    private List<String> images;
}
