package com.rnagaraju.goflights.controller.user;

import com.rnagaraju.goflights.dto.user.UserBookingDTO;
import com.rnagaraju.goflights.service.user.UserBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserBookingDTO> getBookingById(@PathVariable("id") Long id) {
        UserBookingDTO booking = bookingService.getBookingById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }
}
