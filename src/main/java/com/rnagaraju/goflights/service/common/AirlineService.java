package com.rnagaraju.goflights.service.common;

import com.rnagaraju.goflights.dto.common.AirlineDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.common.AirlineMapper;
import com.rnagaraju.goflights.model.Airline;
import com.rnagaraju.goflights.repository.common.AirlineRepository;
import com.rnagaraju.goflights.specification.AirlineSpecification;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    public List<AirlineDTO> getAllAirlines() {
        List<Airline> airlines = airlineRepository.findAll();
        return AirlineMapper.toDTOList(airlines);
    }

    public AirlineDTO getAirlineById(Long id){
        Airline airline = airlineRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Airline not found with id " + id));
        return AirlineMapper.toDTO(airline);
    }

    public void deleteAirlineById(Long id) {
        Airline airline = airlineRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Airline not found with id " + id));
        // Attempt to delete the airline
        try{
            airlineRepository.delete(airline);
        }catch (DataIntegrityViolationException ex){
            // Handle foreign key constraint violation
            throw new DataIntegrityViolationException("Cannot delete airline. It may be linked to exisiting flights and bookings.");
        }
    }

    public AirlineDTO createAirline(AirlineDTO airlineDTO) {
        try {
            Airline airline = AirlineMapper.toEntity(airlineDTO);
            Airline savedAirline=airlineRepository.save(airline);
            return AirlineMapper.toDTO(savedAirline);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Data integrity violation occurred.", e);
        } catch (ConstraintViolationException e) {
            throw new RuntimeException("Validation error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred.", e);
        }
    }


    public List<AirlineDTO> findAirlines(String name, BigDecimal minRevenue, LocalDateTime certificationDate,
                                         String headquarters, Integer minEmployees, Integer maxEmployees) {

        // Build the specification dynamically using conditional if statements
        Specification<Airline> specification = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            specification = specification.and(AirlineSpecification.hasNameLike(name));
        }
        if (minRevenue != null) {
            specification = specification.and(AirlineSpecification.hasMinRevenue(minRevenue));
        }
        if (certificationDate != null) {
            specification = specification.and(AirlineSpecification.hasCertificationDateBeforeOrOn(certificationDate));
        }
        if (headquarters != null && !headquarters.isEmpty()) {
            specification = specification.and(AirlineSpecification.hasHeadquarters(headquarters));
        }
        if (minEmployees != null) {
            specification = specification.and(AirlineSpecification.hasMinEmployees(minEmployees));
        }
        if (maxEmployees != null) {
            specification = specification.and(AirlineSpecification.hasMaxEmployees(maxEmployees));
        }

        List<Airline> airlines = airlineRepository.findAll(specification);
        return AirlineMapper.toDTOList(airlines);
    }
}
