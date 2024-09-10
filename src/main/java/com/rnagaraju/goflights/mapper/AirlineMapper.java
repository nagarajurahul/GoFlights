package com.rnagaraju.goflights.mapper;

import com.rnagaraju.goflights.dto.AirlineDTO;
import com.rnagaraju.goflights.model.Airline;
import com.rnagaraju.goflights.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class AirlineMapper {

    public static AirlineDTO toDTO(Airline airline) {
        if(airline == null) {
            return null;
        }

        // Get the list of flight IDs from the flights list
        List<Long> flightIds = airline.getFlights().stream()
                .map(Flight::getId) // Extract the IDs
                .collect(Collectors.toList());

        return new AirlineDTO(
                airline.getAirlineName(),
                airline.getContact(),
                airline.getEmail(),
                airline.getAddress(),
                airline.getCertificationDateTime(),
                airline.getCustomerReviews(),
                flightIds
        );
    }
}
