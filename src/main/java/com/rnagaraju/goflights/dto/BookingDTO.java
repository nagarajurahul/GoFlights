package com.rnagaraju.goflights.dto;

import java.time.LocalDateTime;

public class BookingDTO {
    private LocalDateTime bookingDateTime;
    private double totalPrice;
    private String seatNumber;
    private String paymentStatus;

    private FlightDTO flight;

    public BookingDTO() {
    }

    public BookingDTO(LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus, FlightDTO flight) {
        this.bookingDateTime = bookingDateTime;
        this.totalPrice = totalPrice;
        this.seatNumber = seatNumber;
        this.paymentStatus = paymentStatus;
        this.flight = flight;
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

    public FlightDTO getFlight() {
        return flight;
    }

    public void setFlight(FlightDTO flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "bookingDateTime=" + bookingDateTime +
                ", totalPrice=" + totalPrice +
                ", seatNumber='" + seatNumber + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", flight=" + flight +
                '}';
    }
}
