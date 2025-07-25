package com.rnagaraju.goflights.controller.common;

import com.rnagaraju.goflights.dto.common.BookingDTO;
import com.rnagaraju.goflights.mapper.common.BookingMapper;
import com.rnagaraju.goflights.model.Booking;
import com.rnagaraju.goflights.service.common.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<BookingDTO> bookingDTOS=bookingService.getBookings();
        if(bookingDTOS.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookingDTOS);
    }

    @PostMapping("/")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO  booking=bookingService.createBooking(bookingDTO);
        if (booking==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable("id") Long id) {
        BookingDTO bookingDTO = bookingService.getBookingById(id);
        return ResponseEntity.ok(bookingDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingById(@PathVariable("id") Long id) {
        bookingService.deleteBookingById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<List<BookingDTO>> getAllBookingsByFlightId(@PathVariable("id") Long id) {
        List<BookingDTO> bookings = bookingService.getAllBookingsByFlightId(id);
        if (bookings.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/passenger/{id}")
    public ResponseEntity<List<BookingDTO>> getAllBookingsByPassengerId(@PathVariable("id") Long id) {
        List<BookingDTO> booking = bookingService.getAllBookingsByPassengerId(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/advBooking/")
    public ResponseEntity<List<BookingDTO>> getBookings(
            @RequestParam(required = false) LocalDateTime startDate,
            @RequestParam(required = false) LocalDateTime endDate,
            @RequestParam(required = false) String bookingStatus,
            @RequestParam(required = false) String bookingClass,
            @RequestParam(required = false) Long flightId,
            @RequestParam(required = false) Long passengerId) {

        List<BookingDTO> bookingDTOs = bookingService.getBookingsByFilters(startDate, endDate, bookingStatus, bookingClass, flightId, passengerId);

        if (bookingDTOs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(bookingDTOs);
    }
}
