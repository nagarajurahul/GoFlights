package com.rnagaraju.goflights.dto.airline;

import com.rnagaraju.goflights.dto.BookingDTO;
import com.rnagaraju.goflights.dto.PassengerDTO;

import java.time.LocalDateTime;

public class AirlineBookingDTO extends BookingDTO {

    private PassengerDTO passenger;

    public AirlineBookingDTO() {
        super();
    }

    public AirlineBookingDTO(LocalDateTime bookingDateTime, double totalPrice, String seatNumber, String paymentStatus, PassengerDTO passenger){
        super(bookingDateTime, totalPrice, seatNumber, paymentStatus);
        this.passenger = passenger;
    }

    public PassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "AirlineBookingDTO{" +
                "bookingDateTime=" + getBookingDateTime() +
                ", totalPrice=" + getTotalPrice() +
                ", seatNumber='" + getSeatNumber() +
                ", paymentStatus='" + getPaymentStatus() +
                "passenger=" + passenger +
                '}';
    }
}
