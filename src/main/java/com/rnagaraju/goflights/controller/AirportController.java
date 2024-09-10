package com.rnagaraju.goflights.controller;

import com.rnagaraju.goflights.dto.AirportDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.model.Airport;
import com.rnagaraju.goflights.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/")
    public ResponseEntity<List<AirportDTO>> getAirports() {
        List<AirportDTO> airportDTOS=airportService.getAllAirports();
        if(airportDTOS.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(airportDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDTO> getAirportById(@PathVariable Long id) {
       AirportDTO airportDTO=airportService.getAirportById(id);
       return ResponseEntity.ok(airportDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirportById(@PathVariable Long id) {
        airportService.deleteAirportById(id);
        return ResponseEntity.noContent().build();
    }
}
