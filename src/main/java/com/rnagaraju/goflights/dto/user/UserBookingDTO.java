package com.rnagaraju.goflights.dto.user;

import java.time.LocalDateTime;

public class UserBookingDTO{
    private Long id;
    private LocalDateTime bookingDateTime;
    private double totalPrice;
    private String seatNumber;
    private String paymentStatus;
    private String bookingStatus;
    private String bookingClass;
    private String specialMealRequest;
    private Long flightId;
    private Long passengerId;



    public UserBookingDTO() {
    }

    public UserBookingDTO(LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus) {
        this.bookingDateTime = bookingDateTime;
        this.totalPrice = totalPrice;
        this.seatNumber = seatNumber;
        this.paymentStatus = paymentStatus;
    }

    public UserBookingDTO(Long id, LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus, String bookingStatus, String bookingClass, String specialMealRequest, Long flightId, Long passengerId) {
        this.id=id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(String bookingClass) {
        this.bookingClass = bookingClass;
    }

    public String getSpecialMealRequest() {
        return specialMealRequest;
    }

    public void setSpecialMealRequest(String specialMealRequest) {
        this.specialMealRequest = specialMealRequest;
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
}
