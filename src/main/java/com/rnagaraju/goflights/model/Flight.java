package com.rnagaraju.goflights.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
//@Table(name="Flight_Table")
public class Flight extends AbstractEntity {

    @NotBlank
    @Column(name="FLIGHT_NAME",nullable=false,unique=true)
    private String flightName;

    @NotBlank
    @Column(name="FLIGHT_SOURCE")
    private String source;

    @NotBlank
    @Column(name="FLIGHT_DESTINATION")
    private String destination;

    @NotNull
    @Column(name="FLIGHT_DURATION")
    private Integer duration;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="FLIGHT_TYPE")
    private FlightType flightType;

    //    @PastOrPresent
    @Column(name="FLIGHT_DEPARTURE_DATE_TIME")
    private LocalDateTime departureDateTime;

    //    @PastOrPresent
    @Column(name="FLIGHT_ARRIVAL_DATE_TIME")
    private LocalDateTime arrivalDateTime;

    @Column(name="FLIGHT_PRICE")
    private Double price;

    @Column(name="FLIGHT_CAPACITY")
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    @Column(name="FLIGHT_STATUS")
    private FlightStatus flightStatus;

    @Column(name="FLIGHT_CARBON_EMISSIONS")
    private Double carbonEmissions;

    @JoinColumn(name = "AIRLINE_ID")
    private Long airlineId;

    @JoinColumn(name = "DEPARTURE_AIRPORT_ID")
    private Long departureAirportId;

    @JoinColumn(name = "ARRIVAL_AIRPORT_ID")
    private Long arrivalAirportId;

    public Flight() {
    }

    public Flight( String flightName, String source, String destination, Integer duration, FlightType flightType) {
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.flightType = flightType;
    }

    public Flight( String flightName, String source, String destination, Integer duration, FlightType flightType, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, Double price, Integer capacity) {
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.flightType = flightType;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.price=price;
        this.capacity=capacity;
    }

    public Flight(String flightName, String source, String destination, Integer duration, FlightType flightType, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, Double price, Integer capacity, FlightStatus flightStatus, Double carbonEmissions, Long airlineId, Long departureAirportId, Long arrivalAirportId) {
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

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
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

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Double getCarbonEmissions() {
        return carbonEmissions;
    }

    public void setCarbonEmissions(Double carbonEmissions) {
        this.carbonEmissions = carbonEmissions;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightName='" + flightName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", duration=" + duration +
                ", flightType=" + flightType +
                ", departureDateTime=" + departureDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                ", price=" + price +
                ", capacity=" + capacity +
                ", airlineId=" + airlineId +
                ", departureAirportId=" + departureAirportId +
                ", arrivalAirportId=" + arrivalAirportId +
                ", flightStatus=" + flightStatus +
                ", carbonEmissions=" + carbonEmissions +
                '}';
    }
}
