package com.rnagaraju.goflights.mapper.common;

import com.rnagaraju.goflights.dto.common.AirlineDTO;
import com.rnagaraju.goflights.model.Airline;
import com.rnagaraju.goflights.model.Airport;

import java.util.List;
import java.util.stream.Collectors;

public class AirlineMapper {

    public static AirlineDTO toDTO(Airline airline) {
        if(airline == null) {
            return null;
        }

        return new AirlineDTO(
                airline.getId(),
                airline.getAirlineName(),
                airline.getContact(),
                airline.getEmail(),
                airline.getAddress(),
                airline.getCertificationDateTime(),
                airline.getCustomerReviews(),
                airline.getLogoUrl(),
                airline.getHeadquarters(),
                airline.getTotalEmployees(),
                airline.getFrequentFlyerProgram(),
                airline.getAnnualRevenue()
        );
    }

    public static List<AirlineDTO> toDTOList(List<Airline> airlines) {
        if(airlines == null) {
            return null;
        }
        return airlines.stream()
                .map(AirlineMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static Airline toEntity(AirlineDTO airlineDTO) {
        if(airlineDTO == null) {
            return null;
        }

        return new Airline(
                airlineDTO.getAirlineName(),
                airlineDTO.getContact(),
                airlineDTO.getEmail(),
                airlineDTO.getAddress(),
                airlineDTO.getCertificationDateTime(),
                airlineDTO.getCustomerReviews(),
                airlineDTO.getLogoUrl(),
                airlineDTO.getHeadquarters(),
                airlineDTO.getTotalEmployees(),
                airlineDTO.getFrequentFlyerProgram(),
                airlineDTO.getAnnualRevenue()
        );
    }
}
