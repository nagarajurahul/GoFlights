package com.rnagaraju.goflights.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name="Flight_Table")
@NamedQuery(name="Flight.findAll",query="select flight from Flight flight where flight.deleted = false")
@NamedQuery(name="Flight.findAllByAirline",query="select flight from Flight flight where flight.airline.id = :id and flight.deleted = false")
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
    private FlightType type;

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
    private FlightStatus status;

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

    public Flight( String flightName, String source, String destination, Integer duration, FlightType type) {
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.type = type;
    }


    public Flight( String flightName, String source, String destination, Integer duration, FlightType type, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.type = type;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }


    public Flight( String flightName, String source, String destination, Integer duration, FlightType type, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, Double price, Integer capacity) {
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.type = type;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.price=price;
        this.capacity=capacity;
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

    public FlightType getType() {
        return type;
    }

    public void setType(FlightType Type) {
        this.type = Type;
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

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
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
                ", type=" + type +
                ", departureDateTime=" + departureDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                ", price=" + price +
                ", capacity=" + capacity +
                ", airlineId=" + airlineId +
                ", departureAirportId=" + departureAirportId +
                ", arrivalAirportId=" + arrivalAirportId +
                ", status=" + status +
                ", carbonEmissions=" + carbonEmissions +
                '}';
    }
}
