package com.rnagaraju.goflights.repository.user;

import com.rnagaraju.goflights.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFlightRepository extends JpaRepository<Flight, Long> {
    Flight findById(long id);
    Flight findByFlightName(String flightName);
}
