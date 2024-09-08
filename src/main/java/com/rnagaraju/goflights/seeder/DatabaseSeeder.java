package com.rnagaraju.goflights.seeder;

import com.rnagaraju.goflights.model.*;
import com.rnagaraju.goflights.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void run(String... args) throws Exception {

        // Creating Airport objects with updated fields
        Airport airport1 = new Airport("Los Angeles International Airport (LAX)", "California", "America/Los Angeles", 1500, LocalDateTime.now(), "LAX", 1234567890L, "info@lax.com", "Wheelchair assistance available");
        Airport airport2 = new Airport("Hartsfield-Jackson Atlanta International Airport", "Georgia", "America/Atlanta", 2200, LocalDateTime.now(), "ATL", 9876543210L, "info@atl.com", "Sign language interpreter available");
        Airport airport3 = new Airport("Indira Gandhi International Airport", "Delhi", "Asia/Kolkata", 3000, LocalDateTime.now(), "DEL", 1122334455L, "info@del.com", "Braille signage available");
        Airport airport4 = new Airport("Abu Dhabi International Airport", "Abu Dhabi", "Asia/Dubai", 2500, LocalDateTime.now(), "AUH", 9988776655L, "info@auh.com", "Service animals permitted");
        Airport airport5 = new Airport("Tokyo Haneda Airport", "Tokyo", "Asia/Tokyo", 3200, LocalDateTime.now(), "HND", 5544332211L, "info@hnd.com", "Priority boarding available");
        Airport airport6 = new Airport("Toronto Pearson International Airport", "Toronto", "America/Toronto", 2800, LocalDateTime.now(), "YYZ", 3344556677L, "info@yyz.com", "Assistance for visually impaired travelers");
        Airport airport7 = new Airport("Heathrow Airport", "London", "Europe/London", 3500, LocalDateTime.now(), "LHR", 2233445566L, "info@lhr.com", "Accessible parking spaces available");
        Airport airport8 = new Airport("Denver International Airport", "Denver", "America/Denver", 2700, LocalDateTime.now(), "DEN", 7788990011L, "info@den.com", "Assistance for travelers with cognitive disabilities");
        Airport airport9 = new Airport("San Francisco International Airport", "San Francisco", "America/Los_Angeles", 3000, LocalDateTime.now(), "SFO", 9900112233L, "info@sfo.com", "Priority security screening available");
        Airport airport10 = new Airport("Chicago O'Hare International Airport", "Chicago", "America/Chicago", 2800, LocalDateTime.now(), "ORD", 6677889900L, "info@ord.com", "Accessible restrooms available");
        Airport airport11 = new Airport("Dubai International Airport", "Dubai", "Asia/Dubai", 4000, LocalDateTime.now(), "DXB", 1122334455L, "info@dxb.com", "Ramps for boarding available");
        Airport airport12 = new Airport("Singapore Changi Airport", "Singapore", "Asia/Singapore", 3500, LocalDateTime.now(), "SIN", 9988776655L, "info@sin.com", "Assistance for travelers with medical conditions");
        Airport airport13 = new Airport("Paris Charles de Gaulle Airport", "Paris", "Europe/Paris", 3000, LocalDateTime.now(), "CDG", 5544332211L, "info@cdg.com", "Emergency evacuation assistance available");
        Airport airport14 = new Airport("Sydney Kingsford Smith Airport", "Sydney", "Australia/Sydney", 2800, LocalDateTime.now(), "SYD", 3344556677L, "info@syd.com", "Assistance for travelers with hearing impairments");
        Airport airport15 = new Airport("Frankfurt Airport", "Frankfurt", "Europe/Berlin", 3200, LocalDateTime.now(), "FRA", 1122334455L, "info@fra.com", "Assistance for travelers with allergies");

        airportRepository.save(airport1);
        airportRepository.save(airport2);
        airportRepository.save(airport3);
        airportRepository.save(airport4);
        airportRepository.save(airport5);
        airportRepository.save(airport6);
        airportRepository.save(airport7);
        airportRepository.save(airport8);
        airportRepository.save(airport9);
        airportRepository.save(airport10);
        airportRepository.save(airport11);
        airportRepository.save(airport12);
        airportRepository.save(airport13);
        airportRepository.save(airport14);
        airportRepository.save(airport15);

        Airline airline1 = new Airline("IIT Airlines", 1234567890L, "iitairlines@iit.com", "IIT Airline Address", LocalDateTime.now(), 100);
        Airline airline2 = new Airline("Seven Seas Aviation", 9876543210L, "info@sevenseasaviation.com", "Seven Seas", LocalDateTime.now(), 200);
        Airline airline3 = new Airline("BlueWing Airlines", 8888888880L, "info@bluewing.com", "BlueWing Airlines Headquarters, Blue Plaza, City", LocalDateTime.now(), 200);
        Airline airline4 = new Airline("Sunrise Airways", 9999999990L, "contact@sunriseairways.com", "Sunrise Airways Building, Sunrise Street, Town", LocalDateTime.now(), 150);
        Airline airline5 = new Airline("SilverCloud Airlines", 10101010100L, "customerservice@silvercloudairlines.com", "SilverCloud Tower, Cloud Avenue, Metropolis", LocalDateTime.now(), 180);
        Airline airline6 = new Airline("Royal Skies Aviation", 11111111110L, "info@royalskiesaviation.com", "Royal Skies Headquarters, Aviation Street, Capital City", LocalDateTime.now(), 220);
        Airline airline7 = new Airline("Emerald Airways", 12121212120L, "contactus@emeraldairways.com", "Emerald Tower, Aviation Road, Emerald City", LocalDateTime.now(), 130);

        airlineRepository.save(airline1);
        airlineRepository.save(airline2);
        airlineRepository.save(airline3);
        airlineRepository.save(airline4);
        airlineRepository.save(airline5);
        airlineRepository.save(airline6);
        airlineRepository.save(airline7);


        // Creating Flight objects
        Flight flight1 = new Flight("AA1001", "Los Angeles", "New York", 300, FlightType.DIRECT, LocalDateTime.of(2025, 5, 1, 8, 0), LocalDateTime.of(2025, 5, 1, 12, 0), 250.00, 200);
        flight1.setAirline(airline1);
        flight1.setDepartureAirport(airport1);
        flight1.setArrivalAirport(airport2);

        Flight flight2 = new Flight("UA2002", "New York", "Los Angeles", 300, FlightType.DIRECT, LocalDateTime.of(2025, 5, 2, 9, 0), LocalDateTime.of(2025, 5, 2, 13, 0), 260.00, 200);
        flight2.setAirline(airline2);
        flight2.setDepartureAirport(airport2);
        flight2.setArrivalAirport(airport1);

        Flight flight3 = new Flight("BA3003", "Chicago", "London", 600, FlightType.CONNECTING, LocalDateTime.of(2025, 5, 3, 10, 0), LocalDateTime.of(2025, 5, 3, 22, 0), 500.00, 150);
        flight3.setAirline(airline3);
        flight3.setDepartureAirport(airport10);
        flight3.setArrivalAirport(airport7);

        Flight flight4 = new Flight("EK4004", "London", "Dubai", 540, FlightType.NON_STOP, LocalDateTime.of(2025, 5, 4, 11, 0), LocalDateTime.of(2025, 5, 5, 3, 0), 600.00, 180);
        flight4.setAirline(airline4);
        flight4.setDepartureAirport(airport7);
        flight4.setArrivalAirport(airport11);

        Flight flight5 = new Flight("SQ5005", "Dubai", "Singapore", 330, FlightType.DIRECT, LocalDateTime.of(2025, 5, 5, 12, 0), LocalDateTime.of(2025, 5, 5, 17, 30), 450.00, 220);
        flight5.setAirline(airline5);
        flight5.setDepartureAirport(airport11);
        flight5.setArrivalAirport(airport12);

        Flight flight6 = new Flight("QF6006", "Singapore", "Sydney", 400, FlightType.DIRECT, LocalDateTime.of(2025, 5, 6, 13, 0), LocalDateTime.of(2025, 5, 6, 19, 0), 420.00, 200);
        flight6.setAirline(airline6);
        flight6.setDepartureAirport(airport12);
        flight6.setArrivalAirport(airport14);

        Flight flight7 = new Flight("LH7007", "Sydney", "Frankfurt", 660, FlightType.CONNECTING, LocalDateTime.of(2025, 5, 7, 14, 0), LocalDateTime.of(2025, 5, 8, 6, 0), 700.00, 250);
        flight7.setAirline(airline7);
        flight7.setDepartureAirport(airport14);
        flight7.setArrivalAirport(airport15);

        Flight flight8 = new Flight("AA8008", "Los Angeles", "Chicago", 240, FlightType.DIRECT, LocalDateTime.of(2025, 5, 8, 15, 0), LocalDateTime.of(2025, 5, 8, 18, 0), 180.00, 180);
        flight8.setAirline(airline1);
        flight8.setDepartureAirport(airport1);
        flight8.setArrivalAirport(airport10);

        Flight flight9 = new Flight("DL9009", "New York", "San Francisco", 360, FlightType.DIRECT, LocalDateTime.of(2025, 5, 9, 16, 0), LocalDateTime.of(2025, 5, 9, 21, 0), 300.00, 220);
        flight9.setAirline(airline2);
        flight9.setDepartureAirport(airport2);
        flight9.setArrivalAirport(airport9);

        Flight flight10 = new Flight("UA1010", "Chicago", "Denver", 180, FlightType.DIRECT, LocalDateTime.of(2025, 5, 10, 17, 0), LocalDateTime.of(2025, 5, 10, 19, 0), 150.00, 150);
        flight10.setAirline(airline3);
        flight10.setDepartureAirport(airport10);
        flight10.setArrivalAirport(airport8);

        Flight flight11 = new Flight("EK1111", "Dubai", "Abu Dhabi", 120, FlightType.DIRECT, LocalDateTime.of(2025, 5, 11, 18, 0), LocalDateTime.of(2025, 5, 11, 20, 0), 100.00, 100);
        flight11.setAirline(airline4);
        flight11.setDepartureAirport(airport11);
        flight11.setArrivalAirport(airport4);

        Flight flight12 = new Flight("SQ1212", "Singapore", "Tokyo", 300, FlightType.DIRECT, LocalDateTime.of(2025, 5, 12, 19, 0), LocalDateTime.of(2025, 5, 12, 23, 0), 280.00, 180);
        flight12.setAirline(airline5);
        flight12.setDepartureAirport(airport12);
        flight12.setArrivalAirport(airport5);

        Flight flight13 = new Flight("QF1313", "Sydney", "Los Angeles", 720, FlightType.CONNECTING, LocalDateTime.of(2025, 5, 13, 20, 0), LocalDateTime.of(2025, 5, 14, 14, 0), 650.00, 200);
        flight13.setAirline(airline6);
        flight13.setDepartureAirport(airport14);
        flight13.setArrivalAirport(airport1);

        Flight flight14 = new Flight("LH1414", "Frankfurt", "Paris", 120, FlightType.DIRECT, LocalDateTime.of(2025, 5, 14, 21, 0), LocalDateTime.of(2025, 5, 14, 23, 0), 90.00, 120);
        flight14.setAirline(airline7);
        flight14.setDepartureAirport(airport15);
        flight14.setArrivalAirport(airport13);

        Flight flight15 = new Flight("AA1515", "Los Angeles", "New York", 300, FlightType.DIRECT, LocalDateTime.of(2025, 5, 15, 22, 0), LocalDateTime.of(2025, 5, 16, 3, 0), 250.00, 200);
        flight15.setAirline(airline1);
        flight15.setDepartureAirport(airport1);
        flight15.setArrivalAirport(airport2);

        Flight flight16 = new Flight("DL1616", "Chicago", "Atlanta", 120, FlightType.DIRECT, LocalDateTime.of(2025, 5, 16, 23, 0), LocalDateTime.of(2025, 5, 17, 1, 0), 100.00, 120);
        flight16.setAirline(airline2);
        flight16.setDepartureAirport(airport10);
        flight16.setArrivalAirport(airport2);

        Flight flight17 = new Flight("UA1717", "Denver", "San Francisco", 180, FlightType.DIRECT, LocalDateTime.of(2025, 5, 17, 12, 0), LocalDateTime.of(2025, 5, 17, 14, 0), 150.00, 150);
        flight17.setAirline(airline3);
        flight17.setDepartureAirport(airport8);
        flight17.setArrivalAirport(airport9);

        Flight flight18 = new Flight("EK1818", "Dubai", "London", 360, FlightType.DIRECT, LocalDateTime.of(2025, 5, 18, 14, 0), LocalDateTime.of(2025, 5, 18, 20, 0), 300.00, 220);
        flight18.setAirline(airline4);
        flight18.setDepartureAirport(airport11);
        flight18.setArrivalAirport(airport7);

        Flight flight19 = new Flight("SQ1919", "Tokyo", "Singapore", 240, FlightType.DIRECT, LocalDateTime.of(2025, 5, 19, 16, 0), LocalDateTime.of(2025, 5, 19, 19, 0), 200.00, 150);
        flight19.setAirline(airline5);
        flight19.setDepartureAirport(airport5);
        flight19.setArrivalAirport(airport12);

        Flight flight20 = new Flight("QF2020", "Sydney", "Paris", 720, FlightType.CONNECTING, LocalDateTime.of(2025, 5, 20, 18, 0), LocalDateTime.of(2025, 5, 21, 10, 0), 650.00, 200);
        flight20.setAirline(airline6);
        flight20.setDepartureAirport(airport14);
        flight20.setArrivalAirport(airport13);

        Flight flight21 = new Flight("LH2121", "Frankfurt", "New York", 540, FlightType.CONNECTING, LocalDateTime.of(2025, 5, 21, 20, 0), LocalDateTime.of(2025, 5, 22, 10, 0), 500.00, 180);
        flight21.setAirline(airline7);
        flight21.setDepartureAirport(airport15);
        flight21.setArrivalAirport(airport2);

        Flight flight22 = new Flight("AA2222", "Los Angeles", "Chicago", 240, FlightType.DIRECT, LocalDateTime.of(2025, 5, 22, 8, 0), LocalDateTime.of(2025, 5, 22, 11, 0), 180.00, 150);
        flight22.setAirline(airline1);
        flight22.setDepartureAirport(airport1);
        flight22.setArrivalAirport(airport10);

        Flight flight23 = new Flight("DL2323", "New York", "Denver", 300, FlightType.DIRECT, LocalDateTime.of(2025, 5, 23, 14, 0), LocalDateTime.of(2025, 5, 23, 17, 0), 220.00, 180);
        flight23.setAirline(airline2);
        flight23.setDepartureAirport(airport2);
        flight23.setArrivalAirport(airport8);

        Flight flight24 = new Flight("UA2424", "San Francisco", "Tokyo", 540, FlightType.CONNECTING, LocalDateTime.of(2025, 5, 24, 16, 0), LocalDateTime.of(2025, 5, 25, 10, 0), 500.00, 200);
        flight24.setAirline(airline3);
        flight24.setDepartureAirport(airport9);
        flight24.setArrivalAirport(airport5);

        Flight flight25 = new Flight("EK2525", "Dubai", "Sydney", 780, FlightType.CONNECTING, LocalDateTime.of(2025, 5, 25, 20, 0), LocalDateTime.of(2025, 5, 26, 16, 0), 700.00, 220);
        flight25.setAirline(airline4);
        flight25.setDepartureAirport(airport11);
        flight25.setArrivalAirport(airport14);

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        flightRepository.save(flight4);
        flightRepository.save(flight5);
        flightRepository.save(flight6);
        flightRepository.save(flight7);
        flightRepository.save(flight8);
        flightRepository.save(flight9);
        flightRepository.save(flight10);
        flightRepository.save(flight11);
        flightRepository.save(flight12);
        flightRepository.save(flight13);
        flightRepository.save(flight14);
        flightRepository.save(flight15);
        flightRepository.save(flight16);
        flightRepository.save(flight17);
        flightRepository.save(flight18);
        flightRepository.save(flight19);
        flightRepository.save(flight20);
        flightRepository.save(flight21);
        flightRepository.save(flight22);
        flightRepository.save(flight23);
        flightRepository.save(flight24);
        flightRepository.save(flight25);

        Passenger passenger1 = new Passenger("John", "Doe", 1234567890L, "john.doe@example.com", "123 Main St, Anytown", "AB123456", "USA", LocalDate.of(1985, 6, 15));
        passenger1.setGenderType(GenderType.MALE);
        passenger1.setSpecialAssistanceRequirements("None");

        Passenger passenger2 = new Passenger("Jane", "Smith", 9876543210L, "jane.smith@example.com", "456 Oak Ave, Othercity", "CD987654", "UK", LocalDate.of(1990, 8, 25));
        passenger2.setGenderType(GenderType.FEMALE);
        passenger2.setSpecialAssistanceRequirements("Wheelchair assistance required");

        Passenger passenger3 = new Passenger("Michael", "Johnson", 5555555555L, "michael.johnson@example.com", "789 Elm St, Anothercity", "EF555555", "Canada", LocalDate.of(1970, 4, 10));
        passenger3.setGenderType(GenderType.MALE);
        passenger3.setSpecialAssistanceRequirements("Sign language interpreter required");

        Passenger passenger4 = new Passenger("Emily", "Williams", 3333333333L, "emily.williams@example.com", "321 Pine St, Yetanothercity", "GH333333", "Australia", LocalDate.of(1988, 9, 5));
        passenger4.setGenderType(GenderType.FEMALE);
        passenger4.setSpecialAssistanceRequirements("Braille signage required");

        Passenger passenger5 = new Passenger("David", "Brown", 4444444444L, "david.brown@example.com", "567 Maple St, Finalcity", "IJ444444", "Germany", LocalDate.of(1982, 3, 20));
        passenger5.setGenderType(GenderType.MALE);
        passenger5.setSpecialAssistanceRequirements("Service animals permitted");

        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);
        passengerRepository.save(passenger3);
        passengerRepository.save(passenger4);
        passengerRepository.save(passenger5);


        // Booking 1
        Booking booking1 = new Booking(LocalDateTime.now(), 250.0, "A12", "Paid", flight1, passenger1);

        // Booking 2
        Booking booking2 = new Booking(LocalDateTime.now(), 300.0, "B23", "Paid", flight2, passenger1);

        // Booking 3
        Booking booking3 = new Booking(LocalDateTime.now(), 200.0, "C34", "Pending", flight3, passenger3);

        // Booking 4
        Booking booking4 = new Booking(LocalDateTime.now(), 350.0, "D45", "Paid", flight4, passenger4);

        // Booking 5
        Booking booking5 = new Booking(LocalDateTime.now(), 280.0, "E56", "Paid", flight5, passenger5);

        // Booking 6
        Booking booking6 = new Booking(LocalDateTime.now(), 320.0, "F67", "Pending", flight1, passenger5);

        // Booking 7
        Booking booking7 = new Booking(LocalDateTime.now(), 270.0, "G78", "Paid", flight2, passenger5);

        // Booking 8
        Booking booking8 = new Booking(LocalDateTime.now(), 380.0, "H89", "Pending", flight1, passenger4);

        // Booking 9
        Booking booking9 = new Booking(LocalDateTime.now(), 290.0, "I90", "Paid", flight2, passenger3);

        // Booking 10
        Booking booking10 = new Booking(LocalDateTime.now(), 310.0, "J01", "Paid", flight5, passenger1);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);
        bookingRepository.save(booking6);
        bookingRepository.save(booking7);
        bookingRepository.save(booking8);
        bookingRepository.save(booking9);
        bookingRepository.save(booking10);


    }
}

