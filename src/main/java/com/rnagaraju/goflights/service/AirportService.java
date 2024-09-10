package com.rnagaraju.goflights.service;

import com.rnagaraju.goflights.dto.AirportDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.AirportMapper;
import com.rnagaraju.goflights.model.Airport;
import com.rnagaraju.goflights.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<AirportDTO> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        return AirportMapper.toDTOList(airports);
    }

    public AirportDTO getAirportById(Long id) {
        Airport airport = airportRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Airport not found with id:"+id));
        return AirportMapper.toDTO(airport);
    }

}
