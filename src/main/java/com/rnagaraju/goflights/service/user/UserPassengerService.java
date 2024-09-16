package com.rnagaraju.goflights.service.user;

import com.rnagaraju.goflights.dto.user.UserPassengerDTO;
import com.rnagaraju.goflights.mapper.user.UserPassengerMapper;
import com.rnagaraju.goflights.model.Passenger;
import com.rnagaraju.goflights.repository.user.UserPassengerRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPassengerService {

    @Autowired
    private UserPassengerRepository passengerRepository;

    public List<UserPassengerDTO> getPassengers(){
        List<Passenger> passengers = passengerRepository.findAll();
        return UserPassengerMapper.toDTOList(passengers);
    }

    public UserPassengerDTO getPassengerById(Long id){
        Passenger passenger = passengerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Passenger not found with id: "+id));
        return UserPassengerMapper.toDTO(passenger);
    }

    public UserPassengerDTO createPassenger(UserPassengerDTO userPassengerDTO) {
        try {
            Passenger passenger = UserPassengerMapper.toEntity(userPassengerDTO);
            Passenger savedPassenger = passengerRepository.save(passenger);
            return UserPassengerMapper.toDTO(savedPassenger);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Data integrity violation occurred.", e);
        } catch (ConstraintViolationException e) {
            throw new RuntimeException("Validation error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred.", e);
        }
    }
}
