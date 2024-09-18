package com.rnagaraju.goflights.controller.airline;

import com.rnagaraju.goflights.dto.airline.AirlineBookingDTO;
import com.rnagaraju.goflights.service.airline.AirlineBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("airline/bookings")
public class AirlineBookingController {

    private AirlineBookingService bookingService;

    @GetMapping("/flight/{id}")
    public ResponseEntity<List<AirlineBookingDTO>> getAllBookingsByFlightId(@PathVariable("id") Long id) {
        List<AirlineBookingDTO> bookings = bookingService.getAllBookingsByFlightId(id);
        if (bookings.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookings);
    }
}
