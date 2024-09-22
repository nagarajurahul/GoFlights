package com.rnagaraju.goflights.controller.common;

import com.rnagaraju.goflights.dto.common.AirlineDTO;
import com.rnagaraju.goflights.service.common.AirlineService;
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

    @PostMapping("/")
    public ResponseEntity<AirlineDTO> createAirline(@RequestBody AirlineDTO airlineDTO) {
       AirlineDTO airline=airlineService.createAirline(airlineDTO);
       if (airline==null) {
           return ResponseEntity.badRequest().build();
       }
       return ResponseEntity.ok(airline);
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
}
