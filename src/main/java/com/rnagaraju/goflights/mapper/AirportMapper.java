package com.rnagaraju.goflights.mapper;

import com.rnagaraju.goflights.dto.AirportDTO;
import com.rnagaraju.goflights.dto.FlightDTO;
import com.rnagaraju.goflights.model.Airport;

import java.util.List;
import java.util.stream.Collectors;

public class AirportMapper {
    public static AirportDTO toDTO(Airport airport) {
        if(airport == null) {
            return null;
        }
        return new AirportDTO(
                airport.getAirportName(),
                airport.getLocation(),
                airport.getTimeZone(),
                airport.getTotalEmployees(),
                airport.getEstablishmentDate(),
                airport.getAirportCode(),
                airport.getContact(),
                airport.getEmail(),
                airport.getAccessibilityFeatures()
        );
    }

    public static List<AirportDTO> toDTOList(List<Airport> airports) {
        if(airports == null) {
            return null;
        }
        return airports.stream()
                .map(AirportMapper::toDTO)
                .collect(Collectors.toList());
    }
}
