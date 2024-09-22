package com.rnagaraju.goflights.service.user;

import com.rnagaraju.goflights.dto.user.RoundTripFlightsDTO;
import com.rnagaraju.goflights.dto.user.UserFlightDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.user.UserFlightMapper;
import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.repository.user.UserFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserFlightService {

    @Autowired
    private UserFlightRepository flightRepository;

    public List<UserFlightDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return UserFlightMapper.toDTOList(flights);
    }

    public UserFlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Flight not found with id: " + id));
        return UserFlightMapper.toDTO(flight);
    }

    public List<UserFlightDTO> getOneWayFlights(String source, String destination, LocalDateTime departureDateTime) {
        // Define a range around the dateTime to account for the entire day
        LocalDateTime startOfDay = departureDateTime.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);

        // Query the database using the date range
        List<Flight> flights = flightRepository.findBySourceAndDestinationAndDepartureDateTimeBetween(
                source, destination, startOfDay, endOfDay);

        return UserFlightMapper.toDTOList(flights);
    }

    public BookingDTO.RoundTripFlightsDTO getRoundTripFlights(String source, String destination,
                                                              LocalDateTime departureDateTime,
                                                              LocalDateTime returnDateTime) {

        LocalDateTime departureStart = departureDateTime.toLocalDate().atStartOfDay();
        LocalDateTime departureEnd = departureStart.plusDays(1).minusNanos(1);

        LocalDateTime returnStart = returnDateTime.toLocalDate().atStartOfDay();
        LocalDateTime returnEnd = returnStart.plusDays(1).minusNanos(1);

        // Find outgoing and return flights
        List<Flight> outgoingFlights = flightRepository.findBySourceAndDestinationAndDepartureDateTimeBetween(
                source, destination, departureStart, departureEnd);

        List<Flight> returnFlights = flightRepository.findBySourceAndDestinationAndDepartureDateTimeBetween(
                destination, source, returnStart, returnEnd);

        // Map flights to DTOs
        BookingDTO.RoundTripFlightsDTO roundTripFlightsDTO = new BookingDTO.RoundTripFlightsDTO();
        roundTripFlightsDTO.setOutgoingFlights(UserFlightMapper.toDTOList(outgoingFlights));
        roundTripFlightsDTO.setReturnFlights(UserFlightMapper.toDTOList(returnFlights));

        return roundTripFlightsDTO;
    }

}
