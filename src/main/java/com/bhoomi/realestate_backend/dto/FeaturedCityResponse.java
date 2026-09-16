package com.bhoomi.realestate_backend.dto;

import com.bhoomi.realestate_backend.entity.FeaturedCity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeaturedCityResponse {
    private Long id;
    private String name, optionsCount, imageUrl;
    private Integer displayOrder;

    public static FeaturedCityResponse fromEntity(FeaturedCity c) {
        FeaturedCityResponse r = new FeaturedCityResponse();
        r.setId(c.getId());
        r.setName(c.getName());
        r.setOptionsCount(c.getOptionsCount());
        r.setImageUrl(c.getImageUrl());
        r.setDisplayOrder(c.getDisplayOrder());
        return r;
    }
}