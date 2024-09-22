package com.rnagaraju.goflights.mapper.common;

import com.rnagaraju.goflights.dto.common.BookingDTO;
import com.rnagaraju.goflights.model.Booking;
import com.rnagaraju.goflights.model.BookingStatus;
import com.rnagaraju.goflights.model.BookingClass;

import java.util.List;
import java.util.stream.Collectors;

public class BookingMapper {
    public static BookingDTO toDTO(Booking booking){
        if(booking == null){
            return null;
        }
        return new BookingDTO(
                booking.getId(),
                booking.getBookingDateTime(),
                booking.getTotalPrice(),
                booking.getSeatNumber(),
                booking.getPaymentStatus(),
                booking.getBookingStatus()!=null?booking.getBookingStatus().getStatus():null,
                booking.getBookingClass()!=null?booking.getBookingClass().getClassName():null,
                booking.getSpecialMealRequest(),
                booking.getFlightId(),
                booking.getPassengerId()
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

    public static Booking toEntity(BookingDTO bookingDTO) {
        if(bookingDTO == null){
            return null;
        }
        return new Booking(
                bookingDTO.getBookingDateTime(),
                bookingDTO.getTotalPrice(),
                bookingDTO.getSeatNumber(),
                bookingDTO.getPaymentStatus(),
                BookingStatus.fromString(bookingDTO.getBookingStatus()),
                BookingClass.fromString(bookingDTO.getBookingClass()),
                bookingDTO.getSpecialMealRequest(),
                bookingDTO.getFlightId(),
                bookingDTO.getPassengerId()
        );
    }
}
