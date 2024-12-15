package com.rnagaraju.goflights.specification;

import com.rnagaraju.goflights.model.Booking;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class BookingSpecification {

    public static Specification<Booking> hasBookingDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.between(root.get("bookingDateTime"), startDate, endDate);
    }

    public static Specification<Booking> hasBookingStatus(String bookingStatus) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("bookingStatus"), bookingStatus);
    }

    public static Specification<Booking> hasBookingClass(String bookingClass) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("bookingClass"), bookingClass);
    }

    public static Specification<Booking> hasFlightId(Long flightId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("flightId"), flightId);
    }

    public static Specification<Booking> hasPassengerId(Long passengerId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("passengerId"), passengerId);
    }
}
