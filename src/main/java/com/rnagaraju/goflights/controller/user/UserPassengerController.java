package com.rnagaraju.goflights.controller.user;

import com.rnagaraju.goflights.dto.user.UserPassengerDTO;
import com.rnagaraju.goflights.service.user.UserPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/passengers")
public class UserPassengerController {

    @Autowired
    private UserPassengerService passengerService;

    // Take-out
    @GetMapping("/")
    public ResponseEntity<List<UserPassengerDTO>> getAllPassengers() {
        List<UserPassengerDTO> passengers = passengerService.getPassengers();
        if (passengers == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengers);
    }

    // Take-out - but how will user get passenger
    @GetMapping("/{id}")
    public ResponseEntity<UserPassengerDTO> getPassengerById(@PathVariable("id") Long id) {
        UserPassengerDTO passenger = passengerService.getPassengerById(id);
        if (passenger == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passenger);
    }

    @PostMapping("/")
    public ResponseEntity<UserPassengerDTO> createPassenger(@RequestBody UserPassengerDTO userPassengerDTO) {
        UserPassengerDTO savedPassenger=passengerService.createPassenger(userPassengerDTO);
        if (savedPassenger == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPassenger);
    }

}
