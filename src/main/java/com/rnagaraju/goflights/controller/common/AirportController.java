package com.rnagaraju.goflights.controller.common;

import com.rnagaraju.goflights.dto.common.AirportDTO;
import com.rnagaraju.goflights.service.common.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/")
    public ResponseEntity<List<AirportDTO>> getAllAirports() {
        List<AirportDTO> airportDTOS=airportService.getAllAirports();
        if(airportDTOS.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(airportDTOS);
    }

    @PostMapping("/")
    public ResponseEntity<AirportDTO> createAirport(@RequestBody AirportDTO airportDTO) {
        AirportDTO savedAirport = airportService.createAirport(airportDTO);
        if(savedAirport==null){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAirport);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDTO> getAirportById(@PathVariable("id") Long id) {
       AirportDTO airportDTO=airportService.getAirportById(id);
       return ResponseEntity.ok(airportDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirportById(@PathVariable("id") Long id) {
        airportService.deleteAirportById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/airportCode/{airportCode}")
    public ResponseEntity<AirportDTO> getAirportByAirportCode(@PathVariable("airportCode") String airportCode) {
        AirportDTO airport = airportService.getAirportByAirportCode(airportCode);
        return ResponseEntity.ok(airport);
    }

    @GetMapping("/airportName/{airportName}")
    public ResponseEntity<AirportDTO> getAirportByAirportName(@PathVariable("airportName") String airportName) {
        AirportDTO airport=airportService.getAirportByAirportName(airportName);
        return ResponseEntity.ok(airport);
    }

    @GetMapping("/searchAirports")
    public ResponseEntity<List<AirportDTO>> searchAirports(
            @RequestParam(required = false) String airportName,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String airportCode,
            @RequestParam(required = false) Integer minRunways,
            @RequestParam(required = false) Integer maxRunways,
            @RequestParam(required = false) Integer minTerminals,
            @RequestParam(required = false) Integer maxTerminals) {

        List<AirportDTO> airports = airportService.searchAirports(airportName, location, airportCode, minRunways, maxRunways, minTerminals, maxTerminals);

        if (airports.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(airports);
    }

}
