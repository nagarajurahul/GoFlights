package com.rnagaraju.goflights.repository.common;

import com.rnagaraju.goflights.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findByAirportCode(String airportCode);
}
