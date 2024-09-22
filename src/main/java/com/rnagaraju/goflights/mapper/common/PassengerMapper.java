package com.rnagaraju.goflights.mapper.common;

import com.rnagaraju.goflights.dto.common.PassengerDTO;
import com.rnagaraju.goflights.model.GenderType;
import com.rnagaraju.goflights.model.Passenger;

import java.util.List;
import java.util.stream.Collectors;

public class PassengerMapper {
    public static PassengerDTO toDTO(Passenger passenger) {
        if(passenger == null) {
            return null;
        }

        return new PassengerDTO(
                passenger.getId(),
                passenger.getFirstName(),
                passenger.getLastName(),
                passenger.getMobileNumber(),
                passenger.getEmailId(),
                passenger.getAddress(),
                passenger.getPassportNumber(),
                passenger.getNationality(),
                passenger.getBirthDate(),
                passenger.getGenderType()!=null?passenger.getGenderType().name():null,
                passenger.getSpecialAssistanceRequirements(),
                passenger.getEmergencyContactName(),
                passenger.getEmergencyContactNumber(),
                passenger.getEmergencyContactRelation()
        );
    }

    public static List<PassengerDTO> toDTOList(List<Passenger> passengers) {
        if(passengers == null) {
            return null;
        }
        return passengers.stream()
                .map(PassengerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static Passenger toEntity(PassengerDTO passengerDTO) {
        if(passengerDTO == null) {
            return null;
        }

        return new Passenger(
                passengerDTO.getFirstName(),
                passengerDTO.getLastName(),
                passengerDTO.getMobileNumber(),
                passengerDTO.getEmailId(),
                passengerDTO.getAddress(),
                passengerDTO.getPassportNumber(),
                passengerDTO.getNationality(),
                passengerDTO.getBirthDate(),
                GenderType.fromString(passengerDTO.getGenderType()),
                passengerDTO.getSpecialAssistanceRequirements(),
                passengerDTO.getEmergencyContactName(),
                passengerDTO.getEmergencyContactNumber(),
                passengerDTO.getEmergencyContactRelation()
        );

    }
}
