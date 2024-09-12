package com.rnagaraju.goflights.mapper;

import com.rnagaraju.goflights.dto.BookingDTO;
import com.rnagaraju.goflights.model.Booking;

import java.util.List;
import java.util.stream.Collectors;

public class BookingMapper {
    public static BookingDTO toDTO(Booking booking){
        if(booking == null){
            return null;
        }
        return new BookingDTO(
                booking.getBookingDateTime(),
                booking.getTotalPrice(),
                booking.getSeatNumber(),
                booking.getPaymentStatus()
        );
    }

    public static List<BookingDTO> toDTOList(List<Booking> bookings) {
        if(bookings == null){
            return null;
        }
        return bookings.stream()
                .map(BookingMapper::toDTO)
                .collect(Collectors.toList());
    }
}
