package com.rnagaraju.goflights.service.user;

import com.rnagaraju.goflights.dto.FlightDTO;
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

    // Confusion - whether return type should be UserFlightDTO or just FlightDTO
    public List<UserFlightDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return UserFlightMapper.toDTOList(flights);
    }

    // Confusion - whether return type should be UserFlightDTO or just FlightDTO
    public FlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Flight not found with id: " + id));
        return UserFlightMapper.toDTO(flight);
    }

    public List<UserFlightDTO> getOneWayFlights(String source, String destination, LocalDateTime dateTime) {
        // Define a range around the dateTime to account for the entire day
        LocalDateTime startOfDay = dateTime.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);

        // Query the database using the date range
        List<Flight> flights = flightRepository.findBySourceAndDestinationAndDepartureDateTimeBetween(
                source, destination, startOfDay, endOfDay);

        return UserFlightMapper.toDTOList(flights);
    }
}
