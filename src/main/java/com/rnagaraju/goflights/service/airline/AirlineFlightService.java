package com.rnagaraju.goflights.service.airline;

import com.rnagaraju.goflights.dto.airline.AirlineFlightDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.airline.AirlineFlightMapper;
import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.repository.airline.AirlineFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineFlightService {
    
    @Autowired
    private AirlineFlightRepository flightRepository;

    public List<AirlineFlightDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return AirlineFlightMapper.toDTOList(flights);
    }

    public AirlineFlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Flight not found with id: " + id));

        return AirlineFlightMapper.toDTO(flight);
    }
}
