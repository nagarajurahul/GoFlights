package com.rnagaraju.goflights.controller.user;

import com.rnagaraju.goflights.dto.user.CreateUserBookingDTO;
import com.rnagaraju.goflights.dto.user.UserBookingDTO;
import com.rnagaraju.goflights.service.user.UserBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users/bookings")
public class UserBookingController {

    @Autowired
    private UserBookingService bookingService;

    @GetMapping("/")
    public ResponseEntity<List<UserBookingDTO>> getAllBookings() {
        List<UserBookingDTO> bookings = bookingService.getAllBookings();
        if (bookings.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookings);
    }

    @PostMapping("/")
    public ResponseEntity<UserBookingDTO> createBooking(@RequestBody CreateUserBookingDTO bookingDTO) {
        UserBookingDTO  booking=bookingService.createBooking(bookingDTO);
        if (booking==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserBookingDTO> getBookingById(@PathVariable("id") Long id) {
        UserBookingDTO booking = bookingService.getBookingById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @GetMapping("/passengers/{id}")
    public ResponseEntity<List<UserBookingDTO>> getBookingsByPassengerId(@PathVariable("id") Long id) {
        List<UserBookingDTO> booking = bookingService.getBookingsByPassengerId(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }
}
