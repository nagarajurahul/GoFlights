package com.rnagaraju.goflights.service.common;

import com.rnagaraju.goflights.dto.airline.AirlineBookingDTO;
import com.rnagaraju.goflights.dto.common.BookingDTO;
import com.rnagaraju.goflights.dto.user.CreateUserBookingDTO;
import com.rnagaraju.goflights.dto.user.UserBookingDTO;
import com.rnagaraju.goflights.exception.ResourceNotFoundException;
import com.rnagaraju.goflights.mapper.airline.AirlineBookingMapper;
import com.rnagaraju.goflights.mapper.common.BookingMapper;
import com.rnagaraju.goflights.mapper.user.UserBookingMapper;
import com.rnagaraju.goflights.model.Booking;
import com.rnagaraju.goflights.repository.common.BookingRepository;
import jakarta.validation.ConstraintViolationException;
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

    public List<BookingDTO> getAllBookingsByFlightId(long id) {
        List<Booking> bookings= bookingRepository.findByFlightId(id);
        return BookingMapper.toDTOList(bookings);
    }

    public List<BookingDTO> getAllBookingsByPassengerId(Long id) {
        List<Booking> bookings = bookingRepository.findByPassengerId(id);
        return BookingMapper.toDTOList(bookings);
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        try {
            Booking booking = BookingMapper.toEntity(bookingDTO);
            Booking savedBooking = bookingRepository.save(booking);
            return BookingMapper.toDTO(savedBooking);
        }catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Data integrity violation occurred.", e);
        } catch (ConstraintViolationException e) {
            throw new RuntimeException("Validation error: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred.", e);
        }
    }
}
