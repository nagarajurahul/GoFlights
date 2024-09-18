package com.rnagaraju.goflights.service.airline;

import com.rnagaraju.goflights.dto.airline.AirlineBookingDTO;
import com.rnagaraju.goflights.mapper.airline.AirlineBookingMapper;
import com.rnagaraju.goflights.model.Booking;
import com.rnagaraju.goflights.repository.airline.AirlineBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineBookingService {

    @Autowired
    private AirlineBookingRepository bookingRepository;

    public List<AirlineBookingDTO> getAllBookingsByFlightId(long id) {
        List<Booking> bookings= bookingRepository.findByFlightId(id);
        return AirlineBookingMapper.toDTOList(bookings);
    }
}
