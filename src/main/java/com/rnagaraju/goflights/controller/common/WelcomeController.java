package com.rnagaraju.goflights.controller.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/goFlights")
    public ResponseEntity<String> goFlights() {
        String welcomeMessage = "Welcome to GoFlights!";
        return new ResponseEntity<>(welcomeMessage, HttpStatus.OK);
    }

}
