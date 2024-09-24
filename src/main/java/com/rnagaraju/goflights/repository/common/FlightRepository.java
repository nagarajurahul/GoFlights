package com.rnagaraju.goflights.repository.common;

import com.rnagaraju.goflights.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;


public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findById(long id);
    List<Flight> findByAirlineId(Long id);
    List<Flight> findBySourceAndDestinationAndDepartureDateTimeBetween(
            String source,
            String destination,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime);
    Flight findByFlightName(String flightName);
}
