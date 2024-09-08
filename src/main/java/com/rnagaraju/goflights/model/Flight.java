package com.rnagaraju.goflights.model;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Flight entity with necessary and helpful fields
 * The entity is persisted in the database with JPA annotations.
 * @author rahul
 */
@Entity
//@Table(name="Flight_Table")
@NamedQuery(name="Flight.findAll",query="select flight from Flight flight where flight.deleted = false")
@NamedQuery(name="Flight.findAllByAirline",query="select flight from Flight flight where flight.airline.id = :id and flight.deleted = false")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

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




    /*
     * Many-to-One Relationship (Flight to Airline):
     * Each flight is operated by one airline.
     */

    @ManyToOne
    @JoinColumn(name = "AIRLINE_ID")
    private Airline airline;

    /**
     *
     * Bi-directional One-to-Many Relationship between Flight and Booking:
     * A flight can have multiple bookings.
     * Each booking belongs to one flight.
     * Flight is Inverse/non-owning side as it is O:M
     * Hence, mapped by here
     */

    //@JsonIgnore
    //@OneToMany(mappedBy = "flight",fetch=FetchType.LAZY)
    @OneToMany(mappedBy = "flight")
    private List<Booking> bookings=new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "DEPARTURE_AIRPORT_ID")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "ARRIVAL_AIRPORT_ID")
    private Airport arrivalAirport;

    @Column(name="FLIGHT_PRICE")
    private Double price;

    @Column(name="FLIGHT_CAPACITY")
    private Integer capacity
            ;

    /**
     * Default constructor
     */
    public Flight() {
    }

    /**
     * Parameterized constructor
     * @param flightName The name of the flight
     * @param source The source of the flight
     * @param destination The destination of the flight
     * @param duration The duration of the flight
     * @param type The type of the flight
     */
    public Flight( String flightName, String source, String destination, Integer duration, FlightType type) {

        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.type = type;
    }

    /**
     * Parameterized constructor
     * @param flightName The name of the flight
     * @param source The source of the flight
     * @param destination The destination of the flight
     * @param duration The duration of the flight
     * @param type The type of the flight
     * @param departureDateTime The departure date and time of the flight
     * @param arrivalDateTime The arrival date and time of the flight
     */
    public Flight( String flightName, String source, String destination, Integer duration, FlightType type, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.type = type;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }

    /**
     * Parameterized constructor
     * @param flightName The name of the flight
     * @param source The source of the flight
     * @param destination The destination of the flight
     * @param duration The duration of the flight
     * @param type The type of the flight
     * @param departureDateTime The departure date and time of the flight
     * @param arrivalDateTime The arrival date and time of the flight
     * @param price The price of the flight
     * @param capacity The capacity of the flight
     */
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

    /**
     * Getter for flightName
     * @return The name of the flight
     */
    public String getFlightName() {
        return flightName;
    }

    /**
     * Setter for flightName
     * @param flightName The name of the flight
     */
    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    /**
     * Getter for source
     * @return The source of the flight
     */
    public String getSource() {
        return source;
    }

    /**
     * Setter for source
     * @param source The source of the flight
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Getter for destination
     * @return The destination of the flight
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Setter for destination
     * @param destination The destination of the flight
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Getter for duration
     * @return The duration of the flight
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Setter for duration
     * @param duration The duration of the flight
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * Getter for type
     * @return The type of the flight
     */
    public FlightType getType() {
        return type;
    }

    /**
     * Setter for type
     * @param Type
     */
    public void setType(FlightType Type) {
        this.type = Type;
    }

    /**
     * Getter for departureDateTime
     * @return The departure date and time of the flight
     */
    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    /**
     * Setter for departureDateTime
     * @param departureDateTime The departure date and time of the flight
     */
    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    /**
     * Getter for arrivalDateTime
     * @return The arrival date and time of the flight
     */
    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    /**
     * Setter for arrivalDateTime
     * @param arrivalDateTime The arrival date and time of the flight
     */
    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    /**
     * Getter for airline
     * @return The airline operating the flight
     */
    public Airline getAirline() {
        return airline;
    }

    /**
     * Setter for airline
     * @param airline The airline operating the flight
     */
    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    //@JsonIgnore

    /**
     * Getter for bookings
     * @return The list of bookings associated with the flight
     */
    public List<Booking> getBookings() {
        return bookings;
        //return new ArrayList<>();
    }

    /**
     * Setter for bookings
     * @param bookings The list of bookings associated with the flight
     */
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * Getter for departureAirport
     * @return The departure airport of the flight
     */
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    /**
     * Setter for departureAirport
     * @param departureAirport The departure airport of the flight
     */
    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    /**
     * Getter for arrivalAirport
     * @return The arrival airport of the flight
     */
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    /**
     * Setter for arrivalAirport
     * @param arrivalAirport The arrival airport of the flight
     */
    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    /**
     * Getter for price
     * @return The price of the flight
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Setter for price
     * @param price The price of the flight
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Getter for capacity
     * @return The capacity of the flight
     */
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * Setter for capacity
     * @param capacity The capacity of the flight
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * Override of toString method
     * @return A string representation of the flight
     */
    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", flightName=" + flightName + ", source=" + source + ", destination=" + destination + ", duration=" + duration + ", type=" + type + ", departureDateTime=" + departureDateTime + ", arrivalDateTime=" + arrivalDateTime + ", price=" + price + ", capacity=" + capacity + '}';
    }


}
