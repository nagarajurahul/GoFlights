package com.rnagaraju.goflights.service.user;

import com.rnagaraju.goflights.dto.user.UserBookingDTO;
import com.rnagaraju.goflights.mapper.user.UserBookingMapper;
import com.rnagaraju.goflights.model.Booking;
import com.rnagaraju.goflights.repository.user.UserBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookingService {

    @Autowired
    private UserBookingRepository bookingRepository;

    public List<UserBookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return UserBookingMapper.toDTOList(bookings);
    }

    public UserBookingDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Booking not found with id: " + id));
        return UserBookingMapper.toDTO(booking);
    }

}
