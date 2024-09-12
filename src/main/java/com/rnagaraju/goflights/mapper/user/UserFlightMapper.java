package com.rnagaraju.goflights.mapper.user;

import com.rnagaraju.goflights.dto.user.UserFlightDTO;
import com.rnagaraju.goflights.mapper.AirlineMapper;
import com.rnagaraju.goflights.mapper.AirportMapper;
import com.rnagaraju.goflights.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class UserFlightMapper {
    public static UserFlightDTO toDTO(Flight flight) {
        if (flight == null) {
            return null;
        }
        return new UserFlightDTO(
                flight.getFlightName(),
                flight.getSource(),
                flight.getDestination(),
                flight.getDuration(),
                flight.getType() != null ? flight.getType().name() : null,
                flight.getDepartureDateTime(),
                flight.getArrivalDateTime(),
                flight.getPrice(),
                flight.getCapacity(),
                AirportMapper.toDTO(flight.getDepartureAirport()),
                AirportMapper.toDTO(flight.getArrivalAirport()),
                AirlineMapper.toDTO(flight.getAirline())
        );
    }

    // Method to map a list of Flights to a list of UserFlightDTOs
    public static List<UserFlightDTO> toDTOList(List<Flight> flights) {
        if (flights == null) {
            return null;
        }
        return flights.stream()
                .map(UserFlightMapper::toDTO) // Use the existing mapping method
                .collect(Collectors.toList());
    }
}
