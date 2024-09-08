package com.rnagaraju.goflights.repository;

import com.rnagaraju.goflights.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
