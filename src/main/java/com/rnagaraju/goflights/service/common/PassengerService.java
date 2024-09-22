package com.rnagaraju.goflights.service.common;

import com.rnagaraju.goflights.dto.common.PassengerDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.common.PassengerMapper;
import com.rnagaraju.goflights.model.Passenger;
import com.rnagaraju.goflights.repository.common.PassengerRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<PassengerDTO> getAllPassengers() {
        List<Passenger> passengers = passengerRepository.findAll();
        return PassengerMapper.toDTOList(passengers);
    }

    public PassengerDTO getPassengerById(Long id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Passenger not found with id: "+id));
        return PassengerMapper.toDTO(passenger);
    }

    public void deletePassengerById(Long id) {
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Passenger not found with id: "+id));
        try {
            passengerRepository.delete(passenger);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Cannot delete passenger. It may be linked to existing bookings.");
        }

    }

    public PassengerDTO createPassenger(PassengerDTO passengerDTO) {
        try {
            Passenger passenger = PassengerMapper.toEntity(passengerDTO);
            Passenger savedPassenger = passengerRepository.save(passenger);
            return PassengerMapper.toDTO(savedPassenger);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Data integrity violation occurred.", e);
        } catch (ConstraintViolationException e) {
            throw new RuntimeException("Validation error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred.", e);
        }
    }
}
