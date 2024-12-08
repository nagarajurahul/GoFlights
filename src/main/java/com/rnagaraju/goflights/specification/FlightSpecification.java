package com.rnagaraju.goflights.specification;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.*;
import com.rnagaraju.goflights.model.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FlightSpecification {

    public static Specification<Flight> hasSource(String source) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("source"), source);
    }

    public static Specification<Flight> hasDestination(String destination) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("destination"), destination);
    }

    public static Specification<Flight> hasPriceBetween(Double minPrice, Double maxPrice) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
    }

    public static Specification<Flight> hasDurationLessThan(Integer maxDuration) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("duration"), maxDuration);
    }

    public static Specification<Flight> isNonStop() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("flightType"), "Direct"); // FlightType.NON_STOP);
    }

    public static Specification<Flight> hasCarbonEmissionsLessThan(Double maxEmissions) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("carbonEmissions"), maxEmissions);
    }

    public static  Specification<Flight> hasDepartureDateAndTime(LocalDateTime startOfDay ) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("arrivalDateTime"), startOfDay);
    }


}
