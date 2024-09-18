package com.rnagaraju.goflights.repository.airline;

import com.rnagaraju.goflights.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineBookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByFlightId(Long flightId);
}
