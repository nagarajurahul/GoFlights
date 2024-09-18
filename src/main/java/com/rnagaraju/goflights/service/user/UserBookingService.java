package com.rnagaraju.goflights.service.user;

import com.rnagaraju.goflights.dto.PassengerDTO;
import com.rnagaraju.goflights.dto.user.CreateUserBookingDTO;
import com.rnagaraju.goflights.dto.user.UserBookingDTO;
import com.rnagaraju.goflights.dto.user.UserFlightDTO;
import com.rnagaraju.goflights.externalClient.flight.FlightService;
import com.rnagaraju.goflights.mapper.user.UserBookingMapper;
import com.rnagaraju.goflights.model.Booking;
import com.rnagaraju.goflights.repository.user.UserBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserBookingService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FlightService flightService;

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

    public List<UserBookingDTO> getAllBookingsByPassengerId(Long id) {
        List<Booking> bookings = bookingRepository.findByPassengerId(id);
        return UserBookingMapper.toDTOList(bookings);
    }

    public UserBookingDTO createBooking(CreateUserBookingDTO bookingDTO) {

        // To-do
        Booking booking=new Booking();
        bookingRepository.save(booking);
        return null;
    }
}
