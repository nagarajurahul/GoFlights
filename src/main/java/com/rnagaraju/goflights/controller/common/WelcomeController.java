package com.rnagaraju.goflights.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/goFlights")
    public String goFlights() {
        return "Welcome to our GoFlights Application";
    }
}
