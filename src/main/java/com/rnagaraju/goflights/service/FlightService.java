package com.rnagaraju.goflights.service;

import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService extends AbstractService<Flight> {

    @Autowired
    FlightRepository flightRepository;

    public Flight createFlight(Long id) {
        Flight flight = flightRepository.findById(id).orElse(null);
        return flight;
    }
}
