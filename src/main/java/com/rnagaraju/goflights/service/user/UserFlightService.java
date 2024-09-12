package com.rnagaraju.goflights.service.user;

import com.rnagaraju.goflights.dto.FlightDTO;
import com.rnagaraju.goflights.dto.user.UserFlightDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.FlightMapper;
import com.rnagaraju.goflights.mapper.user.UserFlightMapper;
import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.repository.user.UserFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
