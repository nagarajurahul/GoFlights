package com.rnagaraju.goflights.dto.user;

import com.rnagaraju.goflights.dto.AirlineDTO;
import com.rnagaraju.goflights.dto.AirportDTO;
import com.rnagaraju.goflights.dto.FlightDTO;

import java.time.LocalDateTime;

public class UserFlightDTO extends FlightDTO {
    private AirlineDTO airline;

    // Default constructor
    public UserFlightDTO() {
        super();
    }

    // Parameterized constructor
    public UserFlightDTO(String flightName, String source, String destination, Integer duration,
                         String type, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime,
                         Double price, Integer capacity, AirportDTO departureAirport, AirportDTO arrivalAirport, AirlineDTO airline) {
        super(flightName, source, destination, duration, type, departureDateTime, arrivalDateTime, price, capacity, departureAirport, arrivalAirport);
        this.airline = airline;
    }

    // Getter and Setter for AirlineDTO
    public AirlineDTO getAirline() {
        return airline;
    }

    public void setAirline(AirlineDTO airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "UserFlightDTO{" +
                "flightName='" + getFlightName() + '\'' +
                ", source='" + getSource() + '\'' +
                ", destination='" + getDestination() + '\'' +
                ", duration=" + getDuration() +
                ", type='" + getType() + '\'' +
                ", departureDateTime=" + getDepartureDateTime() +
                ", arrivalDateTime=" + getArrivalDateTime() +
                ", price=" + getPrice() +
                ", capacity=" + getCapacity() +
                ", departureAirport=" + getDepartureAirport() +
                ", arrivalAirport=" + getArrivalAirport() +
                ", airline=" + getAirline() +
                '}';
    }

// Does not work just because fields are in super class

//    @Override
//    public String toString() {
//        return "UserFlightDTO{" +
//                "flightName='" + flightName + '\'' +
//                ", source='" + source + '\'' +
//                ", destination='" + destination + '\'' +
//                ", duration=" + duration +
//                ", type='" + type + '\'' +
//                ", departureDateTime=" + departureDateTime +
//                ", arrivalDateTime=" + arrivalDateTime +
//                ", price=" + price +
//                ", capacity=" + capacity +
//                ", departureAirport=" + departureAirport +
//                ", arrivalAirport=" + arrivalAirport +
//                "airline=" + airline +
//                '}';
//    }
}
