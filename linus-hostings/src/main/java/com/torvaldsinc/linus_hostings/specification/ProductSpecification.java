package com.torvaldsinc.linus_hostings.specification;

import org.springframework.data.jpa.domain.Specification;

import com.torvaldsinc.linus_hostings.model.Product;

public class ProductSpecification {
    private static Specification<Product> nameLike(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.trim().isEmpty()) {
                return null;
            }
            return criteriaBuilder.like(
                criteriaBuilder.lower(root.get("name")),
                "%" + name.toLowerCase().trim() + "%"
            );
        };
    }

    private static Specification<Product> priceBetween(Integer min, Integer max) {
        return (root, query, criteriaBuilder) -> {
            if (min == null && max == null) {
                return null;
            } else if (min != null && max != null) {
                return criteriaBuilder.between(root.get("cost"), min, max);
            } else if (min != null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), min);
            } else {
                return criteriaBuilder.lessThanOrEqualTo(root.get("cost"), max);
            }
        };
    }

    public static Specification<Product> filter(String name, Integer min, Integer max) {
        return Specification.allOf(nameLike(name)).and(priceBetween(min, max));
    }
}
