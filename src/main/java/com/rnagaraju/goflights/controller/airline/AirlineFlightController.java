package com.rnagaraju.goflights.controller.airline;

import com.rnagaraju.goflights.dto.airline.AirlineFlightDTO;
import com.rnagaraju.goflights.service.airline.AirlineFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public ResponseEntity<AirlineFlightDTO> getFlightById(@PathVariable("id") Long id) {
        AirlineFlightDTO flightDTO = flightService.getFlightById(id);
        if (flightDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flightDTO);
    }
}
