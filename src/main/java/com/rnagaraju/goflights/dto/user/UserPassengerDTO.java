package com.rnagaraju.goflights.dto.user;

import com.rnagaraju.goflights.dto.BookingDTO;
import com.rnagaraju.goflights.dto.PassengerDTO;

import java.time.LocalDate;
import java.util.List;

public class UserPassengerDTO  extends PassengerDTO {

    List<BookingDTO> bookings;

    public UserPassengerDTO() {
        super();
    }

    public UserPassengerDTO(String firstName, String lastName,
                            Long mobileNumber, String emailId, String address,
                            String passportNumber, String nationality,
                            LocalDate birthDate, String genderType,
                            List<BookingDTO> bookings) {
        super(firstName, lastName, mobileNumber, emailId, address, passportNumber, nationality, birthDate, genderType);
        this.bookings = bookings;
    }

    public List<BookingDTO> getBookings() {
        return bookings;
    }

    public void setBooking(List<BookingDTO> bookings) {
        this.bookings = bookings;
    }
}
