package com.rnagaraju.goflights.controller.user;

import com.rnagaraju.goflights.dto.common.BookingDTO;
import com.rnagaraju.goflights.dto.user.UserFlightDTO;
import com.rnagaraju.goflights.service.user.UserFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user/flights/")
public class UserFlightController {

    @Autowired
    private UserFlightService flightService;

    @GetMapping("/")
    public ResponseEntity<List<UserFlightDTO>> getAllFlights() {
        List<UserFlightDTO> flights=flightService.getAllFlights();
        if(flights.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFlightDTO> getFlightById(@PathVariable Long id) {
        UserFlightDTO flight=flightService.getFlightById(id);
        if(flight == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @GetMapping("/search/one-way")
    public ResponseEntity<List<UserFlightDTO>> getOneWayFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime departureDateTime) {

        // Call service to fetch flights based on source, destination, and departureDateTime
        List<UserFlightDTO> flights = flightService.getOneWayFlights(source, destination, departureDateTime);

        if(flights.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/search/round-trip")
    public ResponseEntity<BookingDTO.RoundTripFlightsDTO> getRoundTripFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime departureDateTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime returnDateTime) {

        // Call service to fetch flights based on source, destination, and date
        BookingDTO.RoundTripFlightsDTO roundTripFlights = flightService.getRoundTripFlights(source, destination, departureDateTime, returnDateTime);

        if(roundTripFlights == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(roundTripFlights, HttpStatus.OK);
    }
}
