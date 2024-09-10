package com.rnagaraju.goflights.controller;

import com.rnagaraju.goflights.dto.AirportDTO;
import com.rnagaraju.goflights.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
