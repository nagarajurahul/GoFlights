package com.rnagaraju.goflights.specification;

import com.rnagaraju.goflights.model.Airline;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AirlineSpecification {

    public static Specification<Airline> hasNameLike(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("airlineName"), "%" + name + "%");
    }

    public static Specification<Airline> hasMinRevenue(BigDecimal minRevenue) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("annualRevenue"), minRevenue);
    }

    public static Specification<Airline> hasCertificationDateBeforeOrOn(LocalDateTime certificationDate) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("certificationDateTime"), certificationDate);
    }

    public static Specification<Airline> hasHeadquarters(String headquarters) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("headquarters"), headquarters);
    }

    public static Specification<Airline> hasMinEmployees(Integer minEmployees) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("totalEmployees"), minEmployees);
    }

    public static Specification<Airline> hasMaxEmployees(Integer maxEmployees) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("totalEmployees"), maxEmployees);
    }

}
