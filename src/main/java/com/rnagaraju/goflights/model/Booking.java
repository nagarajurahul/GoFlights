package com.rnagaraju.goflights.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
@NamedQuery(name="Booking.findAll",query="select booking from Booking booking where booking.deleted = false")
@NamedQuery(name = "Booking.findByUsername", query="select booking from Booking booking where booking.username= :uname and booking.deleted = false")
public class Booking extends AbstractEntity{

    @PastOrPresent
    @Column(name = "BOOKING_DATE_TIME")
    private LocalDateTime bookingDateTime;

    @Column(name = "BOOKING_TOTAL_PRICE")
    private double totalPrice;


    @Column(name = "BOOKING_SEAT_NUMBER")
    private String seatNumber;


    @Column(name = "BOOKING_PAYMENT_STATUS")
    private String paymentStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "BOOKING_CLASS")
    private BookingClass bookingClass;

    @Column(name = "BOOKING_SPECIAL_MEAL_REQUEST")
    private String specialMealRequest;

    @JoinColumn(name = "FLIGHT_ID")
    private Long flightId;

    @JoinColumn(name = "PASSENGER_ID")
    private Long passengerId;

    public Booking() {
    }

    public Booking(LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus) {
        this.bookingDateTime = bookingDateTime;
        this.totalPrice = totalPrice;
        this.seatNumber = seatNumber;
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public BookingClass getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(BookingClass bookingClass) {
        this.bookingClass = bookingClass;
    }

    public String getSpecialMealRequest() {
        return specialMealRequest;
    }

    public void setSpecialMealRequest(String specialMealRequest) {
        this.specialMealRequest = specialMealRequest;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDateTime=" + bookingDateTime +
                ", totalPrice=" + totalPrice +
                ", seatNumber='" + seatNumber + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", bookingClass=" + bookingClass + '\'' +
                ", specialMealRequest='" + specialMealRequest + '\'' +
                ", flightId=" + flightId +
                ", passengerId=" + passengerId +
                '}';
    }
}
