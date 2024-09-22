package com.rnagaraju.goflights.repository.common;

import com.rnagaraju.goflights.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
