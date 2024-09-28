package com.rnagaraju.goflights.specification;

import com.rnagaraju.goflights.model.Airport;
import org.springframework.data.jpa.domain.Specification;

public class AirportSpecifications {

    public static Specification<Airport> hasAirportName(String airportName) {
        return (root,query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("airportName"), airportName);
    }

    // Specification for filtering by location
    public static Specification<Airport> hasLocation(String location) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("location"), location);
    }

    public static Specification<Airport> hasAirportCode(String airportCode){
        return (root, query, criteriaBuilder)->
                criteriaBuilder.equal(root.get("airportCode"), airportCode);
    }

    // Specification for filtering by minimum runways (mapped to runwayCount)
    public static Specification<Airport> hasMinRunways(Integer minRunways) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("runwayCount"), minRunways);
    }

    // Specification for filtering by maximum runways (mapped to runwayCount)
    public static Specification<Airport> hasMaxRunways(Integer maxRunways) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("runwayCount"), maxRunways);
    }

    // Specification for filtering by minimum terminals (mapped to terminalCount)
    public static Specification<Airport> hasMinTerminals(Integer minTerminals) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("terminalCount"), minTerminals);
    }

    // Specification for filtering by maximum terminals (mapped to terminalCount)
    public static Specification<Airport> hasMaxTerminals(Integer maxTerminals) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("terminalCount"), maxTerminals);
    }
}
