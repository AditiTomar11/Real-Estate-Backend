package com.bhoomi.realestate_backend.dto;

import com.bhoomi.realestate_backend.dto.PropertyRequest;
import com.bhoomi.realestate_backend.repository.PropertyRepository;
import com.bhoomi.realestate_backend.specification.PropertySpecification;
import com.bhoomi.realestate_backend.entity.PropertyStatus;
import com.bhoomi.realestate_backend.entity.Property;
import com.bhoomi.realestate_backend.entity.PropertyType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PropertyResponse {
    private Long id;
    private String title;
    private String city;
    private String locality;
    private PropertyType type;
    private Integer bhk;
    private Long price;
    private Integer areaSqft;
    private PropertyStatus status;
    private String description;
    private List<String> images;

    public static PropertyResponse fromEntity(Property p) {
        PropertyResponse r = new PropertyResponse();
        r.setId(p.getId());
        r.setTitle(p.getTitle());
        r.setCity(p.getCity());
        r.setLocality(p.getLocality());
        r.setType(p.getType());
        r.setBhk(p.getBhk());
        r.setPrice(p.getPrice());
        r.setAreaSqft(p.getAreaSqft());
        r.setStatus(p.getStatus());
        r.setDescription(p.getDescription());
        r.setImages(p.getImages());
        return r;
    }
}
