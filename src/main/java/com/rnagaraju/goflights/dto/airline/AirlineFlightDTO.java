package com.rnagaraju.goflights.dto.airline;

import com.rnagaraju.goflights.dto.AirportDTO;
import com.rnagaraju.goflights.dto.FlightDTO;

import java.time.LocalDateTime;
import java.util.List;

public class AirlineFlightDTO extends FlightDTO {

    private List<AirlineBookingDTO> booking;

    public AirlineFlightDTO() {
        super();
    }

    public AirlineFlightDTO(String flightName, String source, String destination, Integer duration,
                            String type, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime,
                            Double price, Integer capacity,
                            AirportDTO departureAirport, AirportDTO arrivalAirport,
                            List<AirlineBookingDTO> booking) {
        super(flightName,source,destination,duration,type,departureDateTime,arrivalDateTime,price,capacity,departureAirport,arrivalAirport);
        this.booking=booking;
    }


    public List<AirlineBookingDTO> getBooking() {
        return booking;
    }

    public void setBooking(List<AirlineBookingDTO> booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "AirlineFlightDTO{" +
                "flightName='" + getFlightName() + '\'' +
                ", source='" + getSource() + '\'' +
                ", destination='" + getDestination() + '\'' +
                ", duration=" + getDuration() +
                ", type='" + getType() + '\'' +
                ", departureDateTime=" + getDepartureDateTime() +
                ", arrivalDateTime=" + getArrivalDateTime() +
                ", price=" + getPrice() +
                ", capacity=" + getCapacity() +
                ", departureAirport=" + getDepartureAirport() +
                ", arrivalAirport=" + getArrivalAirport() +
                "booking=" + booking +
                '}';
    }
}
