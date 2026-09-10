package com.bhoomi.realestate_backend.specification;
import com.bhoomi.realestate_backend.entity.Property;
import com.bhoomi.realestate_backend.entity.PropertyType;
import org.springframework.data.jpa.domain.Specification;

public class PropertySpecification {

    public static Specification<Property> withFilters(
            String city, PropertyType type, Integer bhk,
            Long minPrice, Long maxPrice, String query) {

        return (root, cq, cb) -> {
            var predicates = cb.conjunction();

            if (city != null && !city.isBlank()) {
                predicates = cb.and(predicates, cb.equal(root.get("city"), city));
            }
            if (type != null) {
                predicates = cb.and(predicates, cb.equal(root.get("type"), type));
            }
            if (bhk != null) {
                predicates = cb.and(predicates, cb.equal(root.get("bhk"), bhk));
            }
            if (minPrice != null) {
                predicates = cb.and(predicates, cb.greaterThanOrEqualTo(root.get("price"), minPrice));
            }
            if (maxPrice != null) {
                predicates = cb.and(predicates, cb.lessThanOrEqualTo(root.get("price"), maxPrice));
            }
            if (query != null && !query.isBlank()) {
                String likePattern = "%" + query.toLowerCase() + "%";
                predicates = cb.and(predicates, cb.or(
                        cb.like(cb.lower(root.get("title")), likePattern),
                        cb.like(cb.lower(root.get("locality")), likePattern),
                        cb.like(cb.lower(root.get("city")), likePattern)
                ));
            }

            return predicates;
        };
    }
}
