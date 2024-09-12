package com.rnagaraju.goflights.mapper.airline;

import com.rnagaraju.goflights.dto.airline.AirlineFlightDTO;
import com.rnagaraju.goflights.mapper.AirportMapper;
import com.rnagaraju.goflights.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class AirlineFlightMapper {
    public static AirlineFlightDTO toDTO(Flight flight) {
        if (flight == null) {
            return null;
        }
        return new AirlineFlightDTO(
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
                AirlineBookingMapper.toDTOList(flight.getBookings())
        );
    }

    // Method to map a list of Flights to a list of FlightDTOs
    public static List<AirlineFlightDTO> toDTOList(List<Flight> flights) {
        if (flights == null) {
            return null;
        }
        return flights.stream()
                .map(AirlineFlightMapper::toDTO) // Use the existing mapping method
                .collect(Collectors.toList());
    }
}
