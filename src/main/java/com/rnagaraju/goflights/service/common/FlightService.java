package com.rnagaraju.goflights.service.common;

import com.rnagaraju.goflights.dto.common.FlightDTO;
import com.rnagaraju.goflights.dto.common.RoundTripFlightsDTO;
import com.rnagaraju.goflights.exception.FlightAlreadyCancelledException;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.common.FlightMapper;
import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.model.FlightStatus;
import com.rnagaraju.goflights.model.FlightType;
import com.rnagaraju.goflights.repository.common.FlightRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import  com.rnagaraju.goflights.specification.FlightSpecification;


import org.springframework.data.jpa.domain.Specification;
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

    public List<FlightDTO> getOneWayFlightsBetweenDates(String source, String destination, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        // Define a range around the dateTime to account for the entire day
        LocalDateTime startOfDay = startDateTime.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = endDateTime.toLocalDate().atStartOfDay().plusDays(1).minusNanos(1);

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

    public List<FlightDTO> getFlightByPrice(String source, String destination,
                                         LocalDateTime departureStart, LocalDateTime departureEnd,
                                         Double minPrice, Double maxPrice) {

        LocalDateTime startOfDay = departureStart.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = departureEnd.toLocalDate().atStartOfDay().plusDays(1).minusNanos(1);

        List<Flight> flights = flightRepository.findBySourceAndDestinationAndDepartureDateTimeBetweenAndPriceBetween(
                source, destination, startOfDay, endOfDay, minPrice, maxPrice);

        return FlightMapper.toDTOList(flights);
    }

    public List<FlightDTO> advancedSearch(
            String source, String destination, LocalDateTime departureStart,Double minPrice, Double maxPrice,
            Integer maxDuration, Boolean nonStop, Double maxEmissions) {


        Specification<Flight> spec = Specification.where(null);

        if (source != null && !source.isEmpty()) {
            spec = spec.and(FlightSpecification.hasSource(source));
        }

        if (departureStart != null ){
            LocalDateTime startOfDay = departureStart.toLocalDate().atStartOfDay();
//            LocalDateTime endOfDay = departureEnd.toLocalDate().atStartOfDay().plusDays(1).minusNanos(1);

            spec = spec.and(FlightSpecification.hasDepartureDateAndTime(startOfDay));

        }

        if (destination != null && !destination.isEmpty()) {
            spec = spec.and(FlightSpecification.hasDestination(destination));
        }

        if (minPrice != null && maxPrice != null) {
            spec = spec.and(FlightSpecification.hasPriceBetween(minPrice, maxPrice));
        }

        if (maxDuration != null) {
            spec = spec.and(FlightSpecification.hasDurationLessThan(maxDuration));
        }

        if (nonStop != null && nonStop) {
            spec = spec.and(FlightSpecification.isNonStop());
        }

        if (maxEmissions != null) {
            spec = spec.and(FlightSpecification.hasCarbonEmissionsLessThan(maxEmissions));
        }

       List<Flight> flights =  flightRepository.findAll(spec);

        return FlightMapper.toDTOList(flights);
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

    public int getAvailableSeats(Long id) {
        // Custom-query
        Integer availableSeats= flightRepository.findAvailableSeatsById(id);

        if(availableSeats==null){
            throw new ResourceNotFoundException("Flight not found with id: " + id);
        }
        return availableSeats;
    }

    public FlightDTO updateFlight(Long id, FlightDTO flightDTO) {
        Flight flight=flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));

        if(flightDTO.getFlightName()!=null){
            flight.setFlightName(flightDTO.getFlightName());
        }
        if (flightDTO.getSource()!=null){
            flight.setSource(flightDTO.getSource());
        }
        if(flightDTO.getDestination()!=null){
            flight.setDestination(flightDTO.getDestination());
        }
        if(flightDTO.getDuration()!=null){
            flight.setDuration(flightDTO.getDuration());
        }
        if(flightDTO.getFlightType()!=null){
            flight.setFlightType(FlightType.fromString(flightDTO.getFlightType()));
        }
        if(flightDTO.getDepartureDateTime()!=null){
            flight.setDepartureDateTime(flightDTO.getDepartureDateTime());
        }
        if(flightDTO.getArrivalDateTime()!=null){
            flight.setArrivalDateTime(flightDTO.getArrivalDateTime());
        }
        if(flightDTO.getPrice()!=null){
            flight.setPrice(flightDTO.getPrice());
        }
        if(flightDTO.getCapacity()!=null){
            flight.setCapacity(flightDTO.getCapacity());
        }
        if(flightDTO.getAvailableSeats()!=null){
            flight.setAvailableSeats(flightDTO.getAvailableSeats());
        }
        if(flightDTO.getFlightStatus()!=null){
            flight.setFlightStatus(FlightStatus.fromString(flightDTO.getFlightStatus()));
        }
        if(flightDTO.getCarbonEmissions()!=null){
            flight.setCarbonEmissions(flightDTO.getCarbonEmissions());
        }
        if (flightDTO.getAirlineId()!=null){
            flight.setAirlineId(flightDTO.getAirlineId());
        }
        if(flightDTO.getDepartureAirportId()!=null){
            flight.setDepartureAirportId(flightDTO.getDepartureAirportId());
        }
        if(flightDTO.getArrivalAirportId()!=null){
            flight.setArrivalAirportId(flightDTO.getArrivalAirportId());
        }

        try{
            flightRepository.save(flight);
            return FlightMapper.toDTO(flight);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Data integrity violation occurred.", e);
        } catch (ConstraintViolationException e) {
            throw new RuntimeException("Validation error: " + e.getMessage(), e);
        }catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred.", e);
        }
    }
}
