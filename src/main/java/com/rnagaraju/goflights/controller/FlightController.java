package com.rnagaraju.goflights.controller;


import com.rnagaraju.goflights.dto.common.FlightDTO;
import com.rnagaraju.goflights.service.common.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/")
    public ResponseEntity<List<FlightDTO>> getFlights(){
        List<FlightDTO> flightDTOS= flightService.getAllFlights();
        if(flightDTOS.isEmpty()){
            return ResponseEntity.noContent().build(); // Response code 204
        }
        return ResponseEntity.ok(flightDTOS); // Response code 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable Long id){
        FlightDTO flightDTO = flightService.getFlightById(id);
        return ResponseEntity.ok(flightDTO); // Response code 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id){
        flightService.deleteFlightById(id);
        return ResponseEntity.noContent().build(); // Response code 204
    }
}