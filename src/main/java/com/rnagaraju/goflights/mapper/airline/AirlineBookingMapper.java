package com.rnagaraju.goflights.mapper.airline;

import com.rnagaraju.goflights.dto.airline.AirlineBookingDTO;
import com.rnagaraju.goflights.mapper.PassengerMapper;
import com.rnagaraju.goflights.model.Booking;

import java.util.List;
import java.util.stream.Collectors;

public class AirlineBookingMapper {
    public static AirlineBookingDTO toDTO(Booking booking){
        if(booking == null){
            return null;
        }
        return new AirlineBookingDTO(
                booking.getBookingDateTime(),
                booking.getTotalPrice(),
                booking.getSeatNumber(),
                booking.getPaymentStatus(),
                PassengerMapper.toDTO(booking.getPassenger())
        );
    }

    public static List<AirlineBookingDTO> toDTOList(List<Booking> bookings) {
        if(bookings == null){
            return null;
        }
        return bookings.stream()
                .map(AirlineBookingMapper::toDTO)
                .collect(Collectors.toList());
    }
}
