package com.rnagaraju.goflights.mapper;

import com.rnagaraju.goflights.dto.BookingDTO;
import com.rnagaraju.goflights.model.Booking;

public class BookingMapper {
    public static BookingDTO toDTO(Booking booking){
        if(booking == null){
            return null;
        }
        return new BookingDTO(
                booking.getBookingDateTime(),
                booking.getTotalPrice(),
                booking.getSeatNumber(),
                booking.getPaymentStatus(),
                FlightMapper.toDTO(booking.getFlight())
        );
    }
}
