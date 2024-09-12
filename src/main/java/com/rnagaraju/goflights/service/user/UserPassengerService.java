package com.rnagaraju.goflights.service.user;

import com.rnagaraju.goflights.dto.user.UserPassengerDTO;
import com.rnagaraju.goflights.mapper.user.UserPassengerMapper;
import com.rnagaraju.goflights.model.Passenger;
import com.rnagaraju.goflights.repository.user.UserPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
