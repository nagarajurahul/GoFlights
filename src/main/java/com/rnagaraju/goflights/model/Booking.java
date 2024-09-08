package com.rnagaraju.goflights.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.Objects;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.FetchType;

/**
 * Booking entity representing a booking with necessary and helpful fields.
 * The entity is persisted in the database with JPA annotations.
 *
 * @author rahul
 */
@Entity
@NamedQuery(name="Booking.findAll",query="select booking from Booking booking where booking.deleted = false")
@NamedQuery(name = "Booking.findByUsername", query="select booking from Booking booking where booking.username= :uname and booking.deleted = false")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Booking extends AbstractEntity{

    /**
     * Date and time of the booking.
     */
    @PastOrPresent
    @Column(name = "BOOKING_DATE_TIME")
    private LocalDateTime bookingDateTime;

    /**
     * Total price of the booking.
     */
    @Column(name = "BOOKING_TOTAL_PRICE")
    private double totalPrice;

    /**
     * Seat number of the booking.
     */
    @Column(name = "BOOKING_SEAT_NUMBER")
    private String seatNumber;

    /**
     * Payment status of the booking.
     */
    @Column(name = "BOOKING_PAYMENT_STATUS")
    private String paymentStatus;

    /**
     * Flight associated with the booking.
     */
    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;

    /**
     * Passenger associated with the booking.
     */
    @ManyToOne
    @JoinColumn(name = "PASSENGER_ID")
    private Passenger passenger;

    /**
     * Username associated with the booking.
     */
    private String username;

    /**
     * Default constructor for the Booking class.
     */
    public Booking() {
    }

    /**
     * Constructs a Booking with the provided booking date and time, total price, seat number, and payment status.
     * @param bookingDateTime The date and time of the booking.
     * @param totalPrice The total price of the booking.
     * @param seatNumber The seat number associated with the booking.
     * @param paymentStatus The payment status of the booking.
     */
    public Booking(LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus) {
        this.bookingDateTime = bookingDateTime;
        this.totalPrice = totalPrice;
        this.seatNumber = seatNumber;
        this.paymentStatus = paymentStatus;
    }


    /**
     * Constructor for the Booking class with parameters.
     *
     * @param bookingDateTime Date and time of the booking.
     * @param totalPrice Total price of the booking.
     * @param seatNumber Seat number of the booking.
     * @param paymentStatus Payment status of the booking.
     * @param flight Flight associated with the booking.
     * @param passenger Passenger associated with the booking.
     */
    public Booking(LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus, Flight flight, Passenger passenger) {
        this.bookingDateTime = bookingDateTime;
        this.totalPrice = totalPrice;
        this.seatNumber = seatNumber;
        this.paymentStatus = paymentStatus;
        this.createBooking(passenger, flight);
    }

    /**
     * Get the date and time of the booking.
     *
     * @return The date and time of the booking.
     */
    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    /**
     * Set the date and time of the booking.
     *
     * @param bookingDateTime The date and time of the booking.
     */
    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    /**
     * Get the total price of the booking.
     *
     * @return The total price of the booking.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Set the total price of the booking.
     *
     * @param totalPrice The total price of the booking.
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Get the seat number of the booking.
     *
     * @return The seat number of the booking.
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * Set the seat number of the booking.
     *
     * @param seatNumber The seat number of the booking.
     */
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * Get the payment status of the booking.
     *
     * @return The payment status of the booking.
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * Set the payment status of the booking.
     *
     * @param paymentStatus The payment status of the booking.
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * Get the flight associated with the booking.
     *
     * @return The flight associated with the booking.
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Set the flight associated with the booking.
     *
     * @param flight The flight associated with the booking.
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * Get the passenger associated with the booking.
     *
     * @return The passenger associated with the booking.
     */
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     * Set the passenger associated with the booking.
     *
     * @param passenger The passenger associated with the booking.
     */
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    /**
     * Get the username associated with the booking.
     *
     * @return The username associated with the booking.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username associated with the booking.
     *
     * @param username The username associated with the booking.
     */
    public void setUsername(String username) {
        this.username = username;
    }


    // Helper methods for managing relationships

    /**
     * Creates a booking and establishes relationships with passenger and flight.
     *
     * @param passenger The passenger associated with the booking.
     * @param flight The flight associated with the booking.
     */
    public void createBooking(Passenger passenger,Flight flight ){
        addFlight(flight);
        addPassenger(passenger);
    }

    /**
     * Cancels the booking and removes relationships with passenger and flight.
     */
    public void cancelBooking(){
        removeFlight(flight);
        removePassenger(passenger);
    }

    /**
     * Cancels the booking for a specific passenger and flight.
     *
     * @param passenger The passenger associated with the booking.
     * @param flight The flight associated with the booking.
     */
    public void cancelBooking(Passenger passenger, Flight flight){
        removeFlight(flight);
        removePassenger(passenger);
    }

    /**
     * Adds the booking to a flight and establishes the relationship.
     *
     * @param flight The flight to add the booking to.
     */
    public void addFlight(Flight flight){
        if(this.flight == null){
            this.flight = flight;
        }
        if(!flight.getBookings().contains(this)){
            flight.getBookings().add(this);
        }
    }

    /**
     * Removes the booking from a flight and breaks the relationship.
     *
     * @param flight The flight to remove the booking from.
     */
    public void removeFlight(Flight flight){
        if(this.flight == flight){
            this.flight = null;
        }
        if(flight.getBookings().contains(this)){
            flight.getBookings().remove(this);
        }
    }

    /**
     * Adds the booking to a passenger and establishes the relationship.
     *
     * @param passenger The passenger to add the booking to.
     */
    public void addPassenger(Passenger passenger){
        if(this.passenger == null){
            this.passenger = passenger;
        }
        if(!passenger.getBookings().contains(this)){
            passenger.getBookings().add(this);
        }
    }

    /**
     * Removes the booking from a passenger and breaks the relationship.
     *
     * @param passenger The passenger to remove the booking from.
     */
    public void removePassenger(Passenger passenger){
        if(this.passenger == passenger){
            this.passenger = null;
        }
        if(passenger.getBookings().contains(this)){
            passenger.getBookings().remove(this);
        }
    }

    /**
     * Get a string representation of the Booking object.
     *
     * @return A string representation of the Booking object.
     */
    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", bookingDateTime=" + bookingDateTime + ", totalPrice=" + totalPrice + ", seatNumber=" + seatNumber + ", paymentStatus=" + paymentStatus + ", flight=" + flight + ", passenger=" + passenger + '}';
    }
}

