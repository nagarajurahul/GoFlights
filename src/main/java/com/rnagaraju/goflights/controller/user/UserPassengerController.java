package com.rnagaraju.goflights.controller.user;

import com.rnagaraju.goflights.dto.user.UserPassengerDTO;
import com.rnagaraju.goflights.service.user.UserPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/passengers")
public class UserPassengerController {

    @Autowired
    private UserPassengerService passengerService;

    @GetMapping("/")
    public ResponseEntity<List<UserPassengerDTO>> getAllPassengers() {
        List<UserPassengerDTO> passengers = passengerService.getPassengers();
        if (passengers == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPassengerDTO> getPassengerById(@PathVariable("id") Long id) {
        UserPassengerDTO passenger = passengerService.getPassengerById(id);
        if (passenger == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passenger);
    }

}
