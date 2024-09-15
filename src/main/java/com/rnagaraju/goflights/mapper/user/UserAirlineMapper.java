package com.rnagaraju.goflights.mapper.user;

import com.rnagaraju.goflights.dto.user.UserAirlineDTO;
import com.rnagaraju.goflights.model.Airline;
import com.rnagaraju.goflights.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class UserAirlineMapper {

    public static UserAirlineDTO toDTO(Airline airline) {
        if(airline == null) {
            return null;
        }

        // Get the list of flight IDs from the flights list
        List<Long> flightIds = airline.getFlights().stream()
                .map(Flight::getId) // Extract the IDs
                .collect(Collectors.toList());

        return new UserAirlineDTO(
                airline.getAirlineName(),
                airline.getContact(),
                airline.getEmail(),
                airline.getAddress(),
                airline.getCertificationDateTime(),
                airline.getCustomerReviews()
        );
    }

    public static List<UserAirlineDTO> toDTOList(List<Airline> airlines) {
        if(airlines == null) {
            return null;
        }
        return airlines.stream()
                .map(UserAirlineMapper::toDTO)
                .collect(Collectors.toList());
    }
}
