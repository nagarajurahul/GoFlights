package com.rnagaraju.goflights.repository.user;

import com.rnagaraju.goflights.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByPassengerId(Long id);
}
