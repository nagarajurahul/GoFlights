package com.rnagaraju.goflights.controller.common;

import com.rnagaraju.goflights.dto.common.PassengerDTO;
import com.rnagaraju.goflights.service.common.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/")
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        List<PassengerDTO> passengerDTOS= passengerService.getAllPassengers();
        if(passengerDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(passengerDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable("id") Long id) {
        PassengerDTO passengerDTO = passengerService.getPassengerById(id);
        return ResponseEntity.ok(passengerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassengerById(@PathVariable Long id) {
        passengerService.deletePassengerById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<PassengerDTO> createPassenger(@RequestBody PassengerDTO passengerDTO) {
        PassengerDTO savedPassenger=passengerService.createPassenger(passengerDTO);
        if (savedPassenger == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPassenger);
    }

}
