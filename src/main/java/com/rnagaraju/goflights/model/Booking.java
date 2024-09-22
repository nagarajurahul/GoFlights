package com.rnagaraju.goflights.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
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
    @Column(name = "BOOKING_Status")
    private BookingStatus bookingStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "BOOKING_Class")
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

    public Booking(LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus, BookingStatus bookingStatus, BookingClass bookingClass, String specialMealRequest, Long flightId, Long passengerId) {
        this.bookingDateTime = bookingDateTime;
        this.totalPrice = totalPrice;
        this.seatNumber = seatNumber;
        this.paymentStatus = paymentStatus;
        this.bookingStatus = bookingStatus;
        this.bookingClass = bookingClass;
        this.specialMealRequest = specialMealRequest;
        this.flightId = flightId;
        this.passengerId = passengerId;
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

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
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
                ", bookingStatus=" + bookingStatus + '\'' +
                ", bookingClass=" + bookingClass + '\'' +
                ", specialMealRequest='" + specialMealRequest + '\'' +
                ", flightId=" + flightId +
                ", passengerId=" + passengerId +
                '}';
    }
}
