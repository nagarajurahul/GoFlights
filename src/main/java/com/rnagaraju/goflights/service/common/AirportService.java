package com.rnagaraju.goflights.service.common;

import com.rnagaraju.goflights.dto.common.AirportDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.common.AirportMapper;
import com.rnagaraju.goflights.model.Airport;
import com.rnagaraju.goflights.repository.common.AirportRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        Airport airport = airportRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Airport not found with id:"+id));
        return AirportMapper.toDTO(airport);
    }

    public void deleteAirportById(Long id) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Airport not found with id:"+id));
        // Attempt to delete the airport
        try {
            airportRepository.delete(airport);
        } catch (DataIntegrityViolationException ex) {
            // Handle foreign key constraint violation
            throw new DataIntegrityViolationException("Cannot delete airport. It may be linked to existing flights.");
        }
    }

    public AirportDTO createAirport(AirportDTO airportDTO) {
        try {
            Airport airport = AirportMapper.toEntity(airportDTO);
            Airport savedAirport=airportRepository.save(airport);
            return AirportMapper.toDTO(savedAirport);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Data integrity violation occurred.", e);
        } catch (ConstraintViolationException e) {
            throw new RuntimeException("Validation error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred.", e);
        }
    }
}
