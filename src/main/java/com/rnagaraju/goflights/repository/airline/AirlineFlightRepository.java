package com.rnagaraju.goflights.repository.airline;

import com.rnagaraju.goflights.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineFlightRepository extends JpaRepository<Flight, Long> {
    Flight findById(long id);
    Flight findByFlightName(String flightName);
}
