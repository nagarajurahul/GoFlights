package com.rnagaraju.goflights.repository.user;

import com.rnagaraju.goflights.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPassengerRepository extends JpaRepository<Passenger, Long> {

}
