package com.rnagaraju.goflights.repository.common;

import com.rnagaraju.goflights.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AirportRepository extends JpaRepository<Airport, Long>, JpaSpecificationExecutor<Airport> {
    Airport findByAirportCode(String airportCode);
}
