package com.rnagaraju.goflights.service;

import com.rnagaraju.goflights.dto.FlightDTO;
import com.rnagaraju.goflights.mapper.FlightMapper;
import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService extends AbstractService<Flight> {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights;
    }

    public FlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id).orElse(null);
        return FlightMapper.toDTO(flight);
    }

}
