package com.rnagaraju.goflights.controller.common;

import com.rnagaraju.goflights.dto.common.AirlineDTO;
import com.rnagaraju.goflights.service.common.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @PostMapping("/")
    public ResponseEntity<AirlineDTO> createAirline(@RequestBody AirlineDTO airlineDTO) {
       AirlineDTO savedAirline=airlineService.createAirline(airlineDTO);
       if (savedAirline==null) {
           return ResponseEntity.badRequest().build();
       }
       return ResponseEntity.status(HttpStatus.CREATED).body(savedAirline);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirlineDTO> getAirlineById(@PathVariable("id") Long id) {
        AirlineDTO airlineDTO = airlineService.getAirlineById(id);
        return ResponseEntity.ok(airlineDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirlineById(@PathVariable("id") Long id) {
        airlineService.deleteAirlineById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<AirlineDTO>> filterAirlines(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal minRevenue,
            @RequestParam(required = false) LocalDateTime certificationDate,
            @RequestParam(required = false) String headquarters,
            @RequestParam(required = false) Integer minEmployees,
            @RequestParam(required = false) Integer maxEmployees) {

        List<AirlineDTO> airlines = airlineService.findAirlines(name, minRevenue, certificationDate, headquarters, minEmployees, maxEmployees);
        if (airlines.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(airlines);
    }
}
