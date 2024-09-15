package com.rnagaraju.goflights.mapper.user;

import com.rnagaraju.goflights.dto.user.UserBookingDTO;
import com.rnagaraju.goflights.model.Booking;

import java.util.List;
import java.util.stream.Collectors;

public class UserBookingMapper {
    public static UserBookingDTO toDTO(Booking booking) {
        if(booking == null) {
            return null;
        }
         return new UserBookingDTO(
                 booking.getBookingDateTime(),
                 booking.getTotalPrice(),
                 booking.getSeatNumber(),
                 booking.getPaymentStatus(),
                 UserFlightMapper.toDTO(booking.getFlight()),
                 UserPassengerMapper.toDTO(booking.getPassenger())
         );
    }

    public static List<UserBookingDTO> toDTOList(List<Booking> bookings) {
        return bookings.stream()
                .map(UserBookingMapper::toDTO)
                .collect(Collectors.toList());
    }
}
