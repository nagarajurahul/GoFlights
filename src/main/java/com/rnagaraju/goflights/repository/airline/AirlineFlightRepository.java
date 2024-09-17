package com.rnagaraju.goflights.repository.airline;

import com.rnagaraju.goflights.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineFlightRepository extends JpaRepository<Flight, Long> {
    Flight findById(long id);
    Flight findByFlightName(String flightName);
    List<Flight> findByAirlineId(Long id);
}
