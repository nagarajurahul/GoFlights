package com.rnagaraju.goflights.service.common;

import com.rnagaraju.goflights.dto.common.AirportDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.common.AirportMapper;
import com.rnagaraju.goflights.model.Airport;
import com.rnagaraju.goflights.repository.common.AirportRepository;
import com.rnagaraju.goflights.specification.AirportSpecifications;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public AirportDTO getAirportByAirportCode(String airportCode) {
        Airport airport = airportRepository.findByAirportCode(airportCode);
        if(airport == null) {
            throw new ResourceNotFoundException("Airport not found with code:"+airportCode);
        }
        return AirportMapper.toDTO(airport);
    }

    public List<AirportDTO> searchAirports(String airportName, String location, String airportCode, Integer minRunways, Integer maxRunways, Integer minTerminals, Integer maxTerminals) {
        Specification<Airport> spec = Specification.where(null); // Initial specification (starts with no condition)

        if(airportName != null) {
            spec=spec.and(AirportSpecifications.hasAirportName(airportName));
        }

        if (location != null) {
            spec = spec.and(AirportSpecifications.hasLocation(location));
        }

        if (airportCode != null) {
            spec=spec.and(AirportSpecifications.hasAirportCode(airportCode));
        }

        if (minRunways != null) {
            spec = spec.and(AirportSpecifications.hasMinRunways(minRunways));
        }

        if (maxRunways != null) {
            spec = spec.and(AirportSpecifications.hasMaxRunways(maxRunways));
        }

        if (minTerminals != null) {
            spec = spec.and(AirportSpecifications.hasMinTerminals(minTerminals));
        }

        if (maxTerminals != null) {
            spec = spec.and(AirportSpecifications.hasMaxTerminals(maxTerminals));
        }

        List<Airport> airports = airportRepository.findAll(spec);
        return AirportMapper.toDTOList(airports);

    }

    public AirportDTO getAirportByAirportName(String airportName) {
        Airport airport = airportRepository.findByAirportName(airportName);
        if(airport == null) {
            throw new ResourceNotFoundException("Airport not found with name:"+airportName);
        }
        return AirportMapper.toDTO(airport);
    }
}
