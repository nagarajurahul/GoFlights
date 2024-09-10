package com.rnagaraju.goflights.controller;


import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Flight getFlight(@PathVariable Long id){
        return flightService.getFlightById(id);
    }
}