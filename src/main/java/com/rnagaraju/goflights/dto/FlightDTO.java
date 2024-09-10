package com.rnagaraju.goflights.dto;

import java.time.LocalDateTime;

public class FlightDTO {

    private String flightName;
    private String source;
    private String destination;
    private Integer duration;
    private String type;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private Double price;
    private Integer capacity;
    private AirlineDTO airline;

    // Default constructor
    public FlightDTO() {
    }

    // Parameterized constructor
    public FlightDTO(String flightName, String source, String destination, Integer duration,
                     String type, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime,
                     Double price, Integer capacity) {
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.type = type;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.price = price;
        this.capacity = capacity;
    }

    // Parameterized constructor
    public FlightDTO(String flightName, String source, String destination, Integer duration,
                     String type, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime,
                     Double price, Integer capacity, AirlineDTO airline) {
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.type = type;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.price = price;
        this.capacity = capacity;
        this.airline = airline;
    }

    // Getters and Setters

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public AirlineDTO getAirline() {
        return airline;
    }

    public void setAirline(AirlineDTO airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "flightName='" + flightName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", duration=" + duration +
                ", type='" + type + '\'' +
                ", departureDateTime=" + departureDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                ", price=" + price +
                ", capacity=" + capacity +
                ", airline=" + airline +
                '}';
    }
}
