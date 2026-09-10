package com.bhoomi.realestate_backend.dto;

import com.bhoomi.realestate_backend.entity.TrendingProject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrendingProjectResponse {
    private Long id;
    private String name, builder, location, type, area, price, imageUrl;
    private boolean isNew;
    private Integer displayOrder;

    public static TrendingProjectResponse fromEntity(TrendingProject p) {
        TrendingProjectResponse r = new TrendingProjectResponse();
        r.setId(p.getId());
        r.setName(p.getName());
        r.setBuilder(p.getBuilder());
        r.setLocation(p.getLocation());
        r.setType(p.getType());
        r.setArea(p.getArea());
        r.setPrice(p.getPrice());
        r.setImageUrl(p.getImageUrl());
        r.setNew(p.isNew());
        r.setDisplayOrder(p.getDisplayOrder());
        return r;
    }
}