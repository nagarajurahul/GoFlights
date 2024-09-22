package com.rnagaraju.goflights.service.common;

import com.rnagaraju.goflights.dto.BookingDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.BookingMapper;
import com.rnagaraju.goflights.model.Booking;
import com.rnagaraju.goflights.repository.common.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingDTO getBookingById(Long id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Booking not found with id:"+id));
        return BookingMapper.toDTO(booking);
    }

    public List<BookingDTO> getBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return BookingMapper.toDTOList(bookings);
    }

    public void deleteBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Booking not found with id:"+id));
        try{
            bookingRepository.delete(booking);
        }catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("Cannot delete booking. It may be linked to existing passengers and flights.");
        }
    }
}
