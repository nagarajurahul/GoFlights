package com.rnagaraju.goflights.controller.common;

import com.rnagaraju.goflights.dto.common.FlightDTO;
import com.rnagaraju.goflights.dto.common.RoundTripFlightsDTO;
import com.rnagaraju.goflights.service.common.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/")
    public ResponseEntity<List<FlightDTO>> getAllFlights(){
        List<FlightDTO> flightDTOS= flightService.getAllFlights();
        if(flightDTOS.isEmpty()){
            return ResponseEntity.noContent().build(); // Response code 204
        }
        return ResponseEntity.ok(flightDTOS); // Response code 200
    }

    @PostMapping("/")
    public ResponseEntity<FlightDTO> createFlight(@RequestBody FlightDTO flightDTO) {
        FlightDTO flight = flightService.createFlight(flightDTO);
        if (flight == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(flight);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable("id") Long id){
        FlightDTO flightDTO = flightService.getFlightById(id);
        return ResponseEntity.ok(flightDTO); // Response code 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightById(@PathVariable("id") Long id){
        flightService.deleteFlightById(id);
        return ResponseEntity.noContent().build(); // Response code 204
    }

    @GetMapping("/search/one-way")
    public ResponseEntity<List<FlightDTO>> getOneWayFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime departureDateTime) {

        // Call service to fetch flights based on source, destination, and departureDateTime
        List<FlightDTO> flights = flightService.getOneWayFlights(source, destination, departureDateTime);

        if(flights.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/search/round-trip")
    public ResponseEntity<RoundTripFlightsDTO> getRoundTripFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime departureDateTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime returnDateTime) {

        // Call service to fetch flights based on source, destination, and date
        RoundTripFlightsDTO roundTripFlights = flightService.getRoundTripFlights(source, destination, departureDateTime, returnDateTime);

        if(roundTripFlights == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(roundTripFlights, HttpStatus.OK);
    }

    @GetMapping("/airline/{id}")
    public ResponseEntity<List<FlightDTO>> getAllFlightsByAirlineId(@PathVariable("id") Long id) {
        List<FlightDTO> flights=flightService.getAllFlightsByAirlineId(id);
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(flights);
    }
}