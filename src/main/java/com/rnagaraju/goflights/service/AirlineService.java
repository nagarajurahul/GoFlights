package com.rnagaraju.goflights.service;

import com.rnagaraju.goflights.dto.AirlineDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.AirlineMapper;
import com.rnagaraju.goflights.model.Airline;
import com.rnagaraju.goflights.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    public AirlineDTO getAirlineById(Long id){
        Airline airline = airlineRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Airline not found with id " + id));
        return AirlineMapper.toDTO(airline);
    }
}
