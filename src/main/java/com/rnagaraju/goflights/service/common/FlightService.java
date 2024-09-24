package com.rnagaraju.goflights.service.common;

import com.rnagaraju.goflights.dto.common.FlightDTO;
import com.rnagaraju.goflights.dto.common.RoundTripFlightsDTO;
import com.rnagaraju.goflights.exception.FlightAlreadyCancelledException;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.common.FlightMapper;
import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.model.FlightStatus;
import com.rnagaraju.goflights.repository.common.FlightRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<FlightDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return FlightMapper.toDTOList(flights);
    }

    public FlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Flight not found with id: " + id));
        return FlightMapper.toDTO(flight);
    }

    public void deleteFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));
        // Attempt to delete the flight
        try {
            flightRepository.delete(flight);
        } catch (DataIntegrityViolationException ex) {
            // Handle foreign key constraint violation
            throw new DataIntegrityViolationException("Cannot delete flight. It may be linked to existing bookings.");
        }
    }

    public List<FlightDTO> getOneWayFlights(String source, String destination, LocalDateTime departureDateTime) {
        // Define a range around the dateTime to account for the entire day
        LocalDateTime startOfDay = departureDateTime.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);

        // Query the database using the date range
        List<Flight> flights = flightRepository.findBySourceAndDestinationAndDepartureDateTimeBetween(
                source, destination, startOfDay, endOfDay);

        return FlightMapper.toDTOList(flights);
    }

    public RoundTripFlightsDTO getRoundTripFlights(String source, String destination,
                                                   LocalDateTime departureDateTime,
                                                   LocalDateTime returnDateTime) {

        LocalDateTime departureStart = departureDateTime.toLocalDate().atStartOfDay();
        LocalDateTime departureEnd = departureStart.plusDays(1).minusNanos(1);

        LocalDateTime returnStart = returnDateTime.toLocalDate().atStartOfDay();
        LocalDateTime returnEnd = returnStart.plusDays(1).minusNanos(1);

        // Find outgoing and return flights
        List<Flight> outgoingFlights = flightRepository.findBySourceAndDestinationAndDepartureDateTimeBetween(
                source, destination, departureStart, departureEnd);

        List<Flight> returnFlights = flightRepository.findBySourceAndDestinationAndDepartureDateTimeBetween(
                destination, source, returnStart, returnEnd);

        // Map flights to DTOs
        RoundTripFlightsDTO roundTripFlightsDTO = new RoundTripFlightsDTO();
        roundTripFlightsDTO.setOutgoingFlights(FlightMapper.toDTOList(outgoingFlights));
        roundTripFlightsDTO.setReturnFlights(FlightMapper.toDTOList(returnFlights));

        return roundTripFlightsDTO;
    }

    public FlightDTO createFlight(FlightDTO flightDTO) {
        try{
            Flight flight=FlightMapper.toEntity(flightDTO);
            Flight savedFlight=flightRepository.save(flight);
            return FlightMapper.toDTO(savedFlight);
        }catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Data integrity violation occurred.", e);
        } catch (ConstraintViolationException e) {
            throw new RuntimeException("Validation error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred.", e);
        }
    }

    public List<FlightDTO> getAllFlightsByAirlineId(Long id) {
        List<Flight> flights = flightRepository.findByAirlineId(id);
        return FlightMapper.toDTOList(flights);
    }

    public FlightDTO getFlightByFlightName(String flightName) {
        // Why or-rlse-throw not coming
        Flight flight=flightRepository.findByFlightName(flightName);
        if(flight==null){
            throw new ResourceNotFoundException("Flight not found with name: " + flightName);
        }
        return FlightMapper.toDTO(flight);
    }

    public boolean cancelFlight(Long id) {
        Flight flight=flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));
        try{
            if(flight.getFlightStatus()==FlightStatus.CANCELLED){
                System.out.println("Inside if");
                // Why throwing 500 error code - please check
                throw new FlightAlreadyCancelledException("Flight with id " + id + " is already cancelled.");
            }
            flight.setFlightStatus(FlightStatus.CANCELLED);
            flightRepository.save(flight);
            return true;
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Data integrity violation occurred.", e);
        }catch (ConstraintViolationException e) {
            throw new RuntimeException("Validation error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred.", e);
        }
    }
}
