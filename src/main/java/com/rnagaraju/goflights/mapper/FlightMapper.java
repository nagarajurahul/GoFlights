package com.rnagaraju.goflights.mapper;

import com.rnagaraju.goflights.dto.FlightDTO;
import com.rnagaraju.goflights.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightMapper {
    public static FlightDTO toDTO(Flight flight) {
        if (flight == null) {
            return null;
        }
        return new FlightDTO(
                flight.getFlightName(),
                flight.getSource(),
                flight.getDestination(),
                flight.getDuration(),
                flight.getType() != null ? flight.getType().name() : null,
                flight.getDepartureDateTime(),
                flight.getArrivalDateTime(),
                flight.getPrice(),
                flight.getCapacity(),
                AirlineMapper.toDTO(flight.getAirline())
        );
    }

    // Method to map a list of Flights to a list of FlightDTOs
    public static List<FlightDTO> toDTOList(List<Flight> flights) {
        if (flights == null) {
            return null;
        }
        return flights.stream()
                .map(FlightMapper::toDTO) // Use the existing mapping method
                .collect(Collectors.toList());
    }
}
