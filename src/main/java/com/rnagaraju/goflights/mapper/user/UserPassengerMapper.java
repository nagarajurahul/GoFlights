package com.rnagaraju.goflights.mapper.user;

import com.rnagaraju.goflights.dto.PassengerDTO;
import com.rnagaraju.goflights.dto.user.UserPassengerDTO;
import com.rnagaraju.goflights.mapper.BookingMapper;
import com.rnagaraju.goflights.model.Passenger;

import java.util.List;
import java.util.stream.Collectors;

public class UserPassengerMapper {
    public static UserPassengerDTO toDTO(Passenger passenger) {
        if(passenger == null) {
            return null;
        }

        return new UserPassengerDTO(
                passenger.getFirstName(),
                passenger.getLastName(),
                passenger.getMobileNumber(),
                passenger.getEmailId(),
                passenger.getAddress(),
                passenger.getPassportNumber(),
                passenger.getNationality(),
                passenger.getBirthDate(),
                passenger.getGenderType()!=null?passenger.getGenderType().name():null,
                BookingMapper.toDTOList(passenger.getBookings())
        );
    }

    public static List<UserPassengerDTO> toDTOList(List<Passenger> passengers) {
        if(passengers == null) {
            return null;
        }
        return passengers.stream()
                .map(UserPassengerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
