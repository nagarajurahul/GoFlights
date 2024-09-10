package com.rnagaraju.goflights.controller;

import com.rnagaraju.goflights.dto.AirlineDTO;
import com.rnagaraju.goflights.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping("/{id}")
    public ResponseEntity<AirlineDTO> getAirline(@PathVariable("id") Long id) {
        AirlineDTO airlineDTO = airlineService.getAirlineById(id);
        return ResponseEntity.ok(airlineDTO);
    }
}
