package com.rnagaraju.goflights.mapper.common;

import com.rnagaraju.goflights.dto.common.AirportDTO;
import com.rnagaraju.goflights.model.Airport;

import java.util.List;
import java.util.stream.Collectors;

public class AirportMapper {
    public static AirportDTO toDTO(Airport airport) {
        if(airport == null) {
            return null;
        }
        return new AirportDTO(
                airport.getId(),
                airport.getAirportName(),
                airport.getLocation(),
                airport.getTimeZone(),
                airport.getTotalEmployees(),
                airport.getEstablishmentDate(),
                airport.getAirportCode(),
                airport.getContact(),
                airport.getEmail(),
                airport.getAccessibilityFeatures(),
                airport.getRunwayCount(),
                airport.getTerminalCount(),
                airport.getAnnualRevenue(),
                airport.getAverageFlightDelay()
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

    public static Airport toEntity(AirportDTO airportDTO) {
        if(airportDTO == null) {
            return null;
        }
        return new Airport(
                airportDTO.getAirportName(),
                airportDTO.getLocation(),
                airportDTO.getTimeZone(),
                airportDTO.getTotalEmployees(),
                airportDTO.getEstablishmentDate(),
                airportDTO.getAirportCode(),
                airportDTO.getContact(),
                airportDTO.getEmail(),
                airportDTO.getAccessibilityFeatures(),
                airportDTO.getRunwayCount(),
                airportDTO.getTerminalCount(),
                airportDTO.getAnnualRevenue(),
                airportDTO.getAverageFlightDelay()
        );
    }
}
