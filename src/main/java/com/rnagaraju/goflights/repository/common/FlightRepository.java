package com.rnagaraju.goflights.repository.common;

import com.rnagaraju.goflights.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findById(long id);
    Flight findByFlightName(String flightName);
}
