package com.rnagaraju.goflights.mapper;

import com.rnagaraju.goflights.dto.PassengerDTO;
import com.rnagaraju.goflights.model.Passenger;

public class PassengerMapper {
    public static PassengerDTO toDTO(Passenger passenger) {
        if(passenger == null) {
            return null;
        }

        return new PassengerDTO(
                passenger.getFirstName(),
                passenger.getLastName(),
                passenger.getMobileNumber(),
                passenger.getEmailId(),
                passenger.getAddress(),
                passenger.getPassportNumber(),
                passenger.getNationality(),
                passenger.getBirthDate(),
                passenger.getGenderType()!=null?passenger.getGenderType().name():null
        );
    }
}
