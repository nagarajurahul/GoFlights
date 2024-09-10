package com.rnagaraju.goflights.controller;


import com.rnagaraju.goflights.dto.FlightDTO;
import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

//    @GetMapping("/goflights")
//    @ResponseBody
//    public String goflights() {
//        return "Hello, Welcome to our GoFlights application!";
//    }

    @GetMapping("/")
    public List<Flight> getFlights(){
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable Long id){
        FlightDTO flightDTO = flightService.getFlightById(id);
        if(flightDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(flightDTO);
    }
}