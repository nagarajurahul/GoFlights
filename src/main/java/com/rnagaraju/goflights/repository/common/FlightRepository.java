package com.rnagaraju.goflights.repository.common;

import com.rnagaraju.goflights.model.Flight;
import jakarta.data.repository.Param;
import jakarta.data.repository.Query;
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

    @Query("SELECT f.availableSeats FROM Flight f WHERE f.id=:flightId")
    Integer findAvailableSeatsById(@Param("flightId") Long flightId);
}
