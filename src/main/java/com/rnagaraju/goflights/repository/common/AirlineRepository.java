package com.rnagaraju.goflights.repository.common;

import com.rnagaraju.goflights.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AirlineRepository extends JpaRepository<Airline, Long> , JpaSpecificationExecutor<Airline> {
}
