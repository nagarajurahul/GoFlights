package com.rnagaraju.goflights.controller;


import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/goflights")
    @ResponseBody
    public String goflights() {
        return "Hello, Welcome to our GoFlights application!";
    }

    @GetMapping("/flights")
    public List<Flight> getFlights(){
        return flightService.getAllFlights();
    }
}