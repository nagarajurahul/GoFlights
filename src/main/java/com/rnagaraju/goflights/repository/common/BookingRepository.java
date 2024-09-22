package com.rnagaraju.goflights.repository.common;

import com.rnagaraju.goflights.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByFlightId(Long flightId);
    List<Booking> findByPassengerId(Long id);
}
