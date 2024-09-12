package com.rnagaraju.goflights.dto.user;

import com.rnagaraju.goflights.dto.BookingDTO;
import com.rnagaraju.goflights.dto.PassengerDTO;

import java.time.LocalDateTime;

public class UserBookingDTO extends BookingDTO {

    private BookingDTO booking;
    private UserFlightDTO flight;

    public UserBookingDTO() {
        super();
    }

    public UserBookingDTO(LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus,
                          PassengerDTO passenger, UserFlightDTO flight) {
        super(bookingDateTime, totalPrice, seatNumber, paymentStatus);
        this.booking=booking;
        this.flight=flight;
    }

    public BookingDTO getBooking() {
        return booking;
    }

    public void setBooking(BookingDTO booking) {
        this.booking = booking;
    }

    public UserFlightDTO getFlight() {
        return flight;
    }

    public void setFlight(UserFlightDTO flight) {
        this.flight = flight;
    }
}
