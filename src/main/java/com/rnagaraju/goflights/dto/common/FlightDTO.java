package com.rnagaraju.goflights.dto.common;

import java.time.LocalDateTime;

public class FlightDTO{
    private Long id;
    private String flightName;
    private String source;
    private String destination;
    private Integer duration;
    private String flightType;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private Double price;
    private Integer capacity;
    private String flightStatus;
    private Double carbonEmissions;
    private Long airlineId;
    private Long departureAirportId;
    private Long arrivalAirportId;


    public FlightDTO() {
    }

    public FlightDTO(String flightName, String source, String destination, Integer duration,
                         String flightType, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime,
                         Double price, Integer capacity) {
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.flightType = flightType;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.price = price;
        this.capacity = capacity;
    }

    public FlightDTO(Long id, String flightName, String source, String destination, Integer duration, String flightType, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, Double price, Integer capacity, String flightStatus, Double carbonEmissions, Long airlineId, Long departureAirportId, Long arrivalAirportId) {
        this.id=id;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.flightType = flightType;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.price = price;
        this.capacity = capacity;
        this.flightStatus = flightStatus;
        this.carbonEmissions = carbonEmissions;
        this.airlineId = airlineId;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
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

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus    = flightStatus;
    }

    public Double getCarbonEmissions() {
        return carbonEmissions;
    }

    public void setCarbonEmissions(Double carbonEmissions) {
        this.carbonEmissions = carbonEmissions;
    }

    public Long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Long airlineId) {
        this.airlineId = airlineId;
    }

    public Long getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(Long departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public Long getArrivalAirportId() {
        return arrivalAirportId;
    }

    public void setArrivalAirportId(Long arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }
}

