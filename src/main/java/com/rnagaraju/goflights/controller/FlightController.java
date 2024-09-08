package com.rnagaraju.goflights.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    @GetMapping("/goflights")
    @ResponseBody
    public String goflights() {
        return "Hello, Welcome to our GoFlights application!";
    }
}