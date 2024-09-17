package com.rnagaraju.goflights.dto.user;

import java.time.LocalDateTime;

public class CreateUserBookingDTO {
    private LocalDateTime bookingDateTime;
    private double totalPrice;
    private String seatNumber;
    private String paymentStatus;

    private Long flightId;
    private Long passengerId;

    public CreateUserBookingDTO() {
    }

    public CreateUserBookingDTO(LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus, Long flightId, Long passengerId) {
        this.bookingDateTime = bookingDateTime;
        this.totalPrice = totalPrice;
        this.seatNumber = seatNumber;
        this.paymentStatus = paymentStatus;
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
}
