package com.rnagaraju.goflights.repository.common;

import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.model.FlightStatus;
import jakarta.data.repository.Param;
import jakarta.data.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import java.time.LocalDateTime;
import java.util.List;


public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {
    Flight findById(long id);
    List<Flight> findByAirlineId(Long id);
    List<Flight> findBySourceAndDestinationAndDepartureDateTimeBetween(
            String source,
            String destination,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime);

    List<Flight> findBySourceAndDestinationAndDepartureDateTimeBetweenAndPriceBetween(
            String source,
            String destination,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime,
            Double minPrice,
            Double maxPrice
    );
    Flight findByFlightName(String flightName);


    @Query("SELECT f.availableSeats FROM Flight f WHERE f.id=:flightId")
    Integer findAvailableSeatsById(@Param("flightId") Long flightId);
}
