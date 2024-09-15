package com.rnagaraju.goflights.dto.user;

import java.time.LocalDateTime;

public class UserBookingDTO{

    private LocalDateTime bookingDateTime;
    private double totalPrice;
    private String seatNumber;
    private String paymentStatus;

    private UserFlightDTO flight;

    private UserPassengerDTO passenger;

    public UserBookingDTO() {
    }

    public UserBookingDTO(LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus,
                          UserFlightDTO flight) {

        this.bookingDateTime = bookingDateTime;
        this.totalPrice = totalPrice;
        this.seatNumber = seatNumber;
        this.paymentStatus = paymentStatus;

        this.flight=flight;
    }

    public UserBookingDTO(LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus,
                          UserFlightDTO flight, UserPassengerDTO passenger) {

        this.bookingDateTime = bookingDateTime;
        this.totalPrice = totalPrice;
        this.seatNumber = seatNumber;
        this.paymentStatus = paymentStatus;

        this.flight=flight;

        this.passenger=passenger;
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

    public UserFlightDTO getFlight() {
        return flight;
    }

    public void setFlight(UserFlightDTO flight) {
        this.flight = flight;
    }

    public UserPassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(UserPassengerDTO passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "bookingDateTime=" + bookingDateTime +
                ", totalPrice=" + totalPrice +
                ", seatNumber='" + seatNumber + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", flight=" + flight + '\'' +
                ", passenger=" + passenger +
                '}';
    }

}
