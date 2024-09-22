package com.rnagaraju.goflights.controller.common;

import com.rnagaraju.goflights.dto.common.BookingDTO;
import com.rnagaraju.goflights.dto.user.UserBookingDTO;
import com.rnagaraju.goflights.service.common.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable Long id) {
        BookingDTO bookingDTO = bookingService.getBookingById(id);
        return ResponseEntity.ok(bookingDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
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

    @PostMapping("/")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO  booking=bookingService.createBooking(bookingDTO);
        if (booking==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }
}
