package com.rnagaraju.goflights.mapper.common;

import com.rnagaraju.goflights.dto.common.FlightDTO;
import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.model.FlightStatus;
import com.rnagaraju.goflights.model.FlightType;

import java.util.List;
import java.util.stream.Collectors;

public class FlightMapper {
    public static FlightDTO toDTO(Flight flight) {
        if (flight == null) {
            return null;
        }
        return new FlightDTO(
                flight.getId(),
                flight.getFlightName(),
                flight.getSource(),
                flight.getDestination(),
                flight.getDuration(),
                flight.getFlightType() != null ? flight.getFlightType().getType() : null,
                flight.getDepartureDateTime(),
                flight.getArrivalDateTime(),
                flight.getPrice(),
                flight.getCapacity(),
                flight.getAvailableSeats(),
                flight.getFlightStatus()!=null? flight.getFlightStatus().getStatus():null,
                flight.getCarbonEmissions(),
                flight.getAirlineId(),
                flight.getDepartureAirportId(),
                flight.getArrivalAirportId()
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

    public static Flight toEntity(FlightDTO flightDTO) {
        if (flightDTO == null) {
            return null;
        }

        return new Flight(
                flightDTO.getFlightName(),
                flightDTO.getSource(),
                flightDTO.getDestination(),
                flightDTO.getDuration(),
                FlightType.fromString(flightDTO.getFlightType()),
                flightDTO.getDepartureDateTime(),
                flightDTO.getArrivalDateTime(),
                flightDTO.getPrice(),
                flightDTO.getCapacity(),
                flightDTO.getAvailableSeats(),
                FlightStatus.fromString(flightDTO.getFlightStatus()),
                flightDTO.getCarbonEmissions(),
                flightDTO.getAirlineId(),
                flightDTO.getDepartureAirportId(),
                flightDTO.getArrivalAirportId()
        );
    }
}
