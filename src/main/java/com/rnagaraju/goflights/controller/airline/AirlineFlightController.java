package com.rnagaraju.goflights.controller.airline;

import com.rnagaraju.goflights.dto.airline.AirlineFlightDTO;
import com.rnagaraju.goflights.service.airline.AirlineFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airline/flights")
public class AirlineFlightController {

    @Autowired
    private AirlineFlightService flightService;

    @GetMapping("/")
    public ResponseEntity<List<AirlineFlightDTO>> getAllFlights() {
        List<AirlineFlightDTO> flights = flightService.getAllFlights();
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(flights);
    }

    @PostMapping("/")
    public ResponseEntity<AirlineFlightDTO> createFlight(@RequestBody AirlineFlightDTO flightDTO) {
        AirlineFlightDTO flight =flightService.createFlight(flightDTO);
        if (flight == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(flight);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineFlightDTO> getFlightById(@PathVariable("id") Long id) {
        AirlineFlightDTO flight = flightService.getFlightById(id);
        if (flight == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flight);
    }

    @GetMapping("/airline/{id}")
    public ResponseEntity<List<AirlineFlightDTO>> getAllFlightsByAirlineId(@PathVariable("id") Long id) {
        List<AirlineFlightDTO> flights=flightService.getAllFlightsByAirlineId(id);
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(flights);
    }


}
