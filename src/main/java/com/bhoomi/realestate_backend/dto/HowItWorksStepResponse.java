package com.bhoomi.realestate_backend.dto;

import com.bhoomi.realestate_backend.entity.HowItWorksStep;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HowItWorksStepResponse {
    private Long id;
    private String stepLabel, icon, title, description;
    private Integer displayOrder;

    public static HowItWorksStepResponse fromEntity(HowItWorksStep s) {
        HowItWorksStepResponse r = new HowItWorksStepResponse();
        r.setId(s.getId());
        r.setStepLabel(s.getStepLabel());
        r.setIcon(s.getIcon());
        r.setTitle(s.getTitle());
        r.setDescription(s.getDescription());
        r.setDisplayOrder(s.getDisplayOrder());
        return r;
    }
}