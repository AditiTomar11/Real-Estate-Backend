package com.bhoomi.realestate_backend.dto;

import com.bhoomi.realestate_backend.entity.Testimonial;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestimonialResponse {
    private Long id;
    private String name, role, avatarUrl, quote;
    private Integer rating, displayOrder;

    public static TestimonialResponse fromEntity(Testimonial t) {
        TestimonialResponse r = new TestimonialResponse();
        r.setId(t.getId());
        r.setName(t.getName());
        r.setRole(t.getRole());
        r.setAvatarUrl(t.getAvatarUrl());
        r.setQuote(t.getQuote());
        r.setRating(t.getRating());
        r.setDisplayOrder(t.getDisplayOrder());
        return r;
    }
}