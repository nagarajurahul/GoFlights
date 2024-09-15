package com.rnagaraju.goflights.mapper.user;

import com.rnagaraju.goflights.dto.user.UserAirportDTO;
import com.rnagaraju.goflights.model.Airport;

import java.util.List;
import java.util.stream.Collectors;

public class UserAirportMapper {
    public static UserAirportDTO toDTO(Airport airport) {
        if(airport == null) {
            return null;
        }
        return new UserAirportDTO(
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

    public static List<UserAirportDTO> toDTOList(List<Airport> airports) {
        if(airports == null) {
            return null;
        }
        return airports.stream()
                .map(UserAirportMapper::toDTO)
                .collect(Collectors.toList());
    }
}
