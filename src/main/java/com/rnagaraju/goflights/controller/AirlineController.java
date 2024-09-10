package com.rnagaraju.goflights.controller;

import com.rnagaraju.goflights.dto.AirlineDTO;
import com.rnagaraju.goflights.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/")
    public ResponseEntity<List<AirlineDTO>> getAllAirlines() {
        List<AirlineDTO> airlines = airlineService.getAllAirlines();
        if (airlines.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(airlines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineDTO> getAirline(@PathVariable("id") Long id) {
        AirlineDTO airlineDTO = airlineService.getAirlineById(id);
        return ResponseEntity.ok(airlineDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable("id") Long id) {
        airlineService.deleteAirlineById(id);
        return ResponseEntity.noContent().build();
    }
}
