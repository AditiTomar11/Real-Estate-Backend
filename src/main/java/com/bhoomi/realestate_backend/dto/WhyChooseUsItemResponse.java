package com.bhoomi.realestate_backend.dto;

import com.bhoomi.realestate_backend.entity.WhyChooseUsItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WhyChooseUsItemResponse {
    private Long id;
    private String icon, title, description;
    private Integer displayOrder;

    public static WhyChooseUsItemResponse fromEntity(WhyChooseUsItem i) {
        WhyChooseUsItemResponse r = new WhyChooseUsItemResponse();
        r.setId(i.getId());
        r.setIcon(i.getIcon());
        r.setTitle(i.getTitle());
        r.setDescription(i.getDescription());
        r.setDisplayOrder(i.getDisplayOrder());
        return r;
    }
}