package com.rnagaraju.goflights.seeder;

import com.rnagaraju.goflights.model.*;
import com.rnagaraju.goflights.repository.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
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

        // Updated Airport objects with realistic data
        Airport airport1 = new Airport("Los Angeles International Airport (LAX)", "California", "America/Los_Angeles", 50000,
                LocalDateTime.of(1930, 10, 1, 0, 0), "LAX", 1234567890L, "info@lax.com",
                "Wheelchair assistance available", 4, 9, new BigDecimal("6500000000"), 12.5);

        Airport airport2 = new Airport("Hartsfield-Jackson Atlanta International Airport", "Georgia", "America/New_York", 63000,
                LocalDateTime.of(1925, 4, 16, 0, 0), "ATL", 9876543210L, "info@atl.com",
                "Sign language interpreter available", 5, 7, new BigDecimal("7000000000"), 10.2);

        Airport airport3 = new Airport("Indira Gandhi International Airport", "Delhi", "Asia/Kolkata", 37000,
                LocalDateTime.of(1962, 5, 2, 0, 0), "DEL", 1122334455L, "info@del.com",
                "Braille signage available", 3, 8, new BigDecimal("3500000000"), 15.8);

        Airport airport4 = new Airport("Abu Dhabi International Airport", "Abu Dhabi", "Asia/Dubai", 26000,
                LocalDateTime.of(1982, 1, 1, 0, 0), "AUH", 9988776655L, "info@auh.com",
                "Service animals permitted", 2, 3, new BigDecimal("3000000000"), 8.7);

        Airport airport5 = new Airport("Tokyo Haneda Airport", "Tokyo", "Asia/Tokyo", 45000,
                LocalDateTime.of(1931, 8, 25, 0, 0), "HND", 5544332211L, "info@hnd.com",
                "Priority boarding available", 5, 4, new BigDecimal("5500000000"), 6.4);

        Airport airport6 = new Airport("Toronto Pearson International Airport", "Toronto", "America/Toronto", 49000,
                LocalDateTime.of(1937, 9, 7, 0, 0), "YYZ", 3344556677L, "info@yyz.com",
                "Assistance for visually impaired travelers", 5, 2, new BigDecimal("6700000000"), 9.8);

        Airport airport7 = new Airport("Heathrow Airport", "London", "Europe/London", 76000,
                LocalDateTime.of(1946, 1, 1, 0, 0), "LHR", 2233445566L, "info@lhr.com",
                "Accessible parking spaces available", 4, 5, new BigDecimal("8500000000"), 11.3);

        Airport airport8 = new Airport("Denver International Airport", "Denver", "America/Denver", 35000,
                LocalDateTime.of(1995, 2, 28, 0, 0), "DEN", 7788990011L, "info@den.com",
                "Assistance for travelers with cognitive disabilities", 6, 3, new BigDecimal("4200000000"), 13.0);

        Airport airport9 = new Airport("San Francisco International Airport", "San Francisco", "America/Los_Angeles", 38000,
                LocalDateTime.of(1927, 5, 7, 0, 0), "SFO", 9900112233L, "info@sfo.com",
                "Priority security screening available", 4, 4, new BigDecimal("6100000000"), 14.5);

        Airport airport10 = new Airport("Chicago O'Hare International Airport", "Chicago", "America/Chicago", 68000,
                LocalDateTime.of(1955, 10, 30, 0, 0), "ORD", 6677889900L, "info@ord.com",
                "Accessible restrooms available", 8, 5, new BigDecimal("9000000000"), 12.8);

        Airport airport11 = new Airport("Dubai International Airport", "Dubai", "Asia/Dubai", 55000,
                LocalDateTime.of(1960, 9, 30, 0, 0), "DXB", 1122334455L, "info@dxb.com",
                "Ramps for boarding available", 2, 3, new BigDecimal("7000000000"), 7.2);

        Airport airport12 = new Airport("Singapore Changi Airport", "Singapore", "Asia/Singapore", 42000,
                LocalDateTime.of(1981, 7, 1, 0, 0), "SIN", 9988776655L, "info@sin.com",
                "Assistance for travelers with medical conditions", 4, 3, new BigDecimal("6000000000"), 9.5);

        Airport airport13 = new Airport("Paris Charles de Gaulle Airport", "Paris", "Europe/Paris", 62000,
                LocalDateTime.of(1974, 3, 8, 0, 0), "CDG", 5544332211L, "info@cdg.com",
                "Emergency evacuation assistance available", 4, 4, new BigDecimal("7500000000"), 11.0);

        Airport airport14 = new Airport("Sydney Kingsford Smith Airport", "Sydney", "Australia/Sydney", 41000,
                LocalDateTime.of(1933, 1, 19, 0, 0), "SYD", 3344556677L, "info@syd.com",
                "Assistance for travelers with hearing impairments", 3, 3, new BigDecimal("4800000000"), 8.3);

        Airport airport15 = new Airport("Frankfurt Airport", "Frankfurt", "Europe/Berlin", 69000,
                LocalDateTime.of(1936, 7, 8, 0, 0), "FRA", 1122334455L, "info@fra.com",
                "Assistance for travelers with allergies", 4, 5, new BigDecimal("8300000000"), 10.9);

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

        Airline airline1 = new Airline("IIT Airlines", 1234567890L, "iitairlines@iit.com", "IIT Airline Address", LocalDateTime.now(), 85, "https://iitairlines.com/logo.png", "IIT Headquarters, Illinois", 100, "IIT Frequent Flyer", new BigDecimal("50000000"));
        Airline airline2 = new Airline("Seven Seas Aviation", 9876543210L, "info@sevenseasaviation.com", "Seven Seas Address, Coastal City", LocalDateTime.now(), 90, "https://sevenseasaviation.com/logo.png", "Seven Seas Headquarters, Coastal City", 200, "Seven Seas Frequent Flyer", new BigDecimal("60000000"));
        Airline airline3 = new Airline("BlueWing Airlines", 8888888880L, "info@bluewing.com", "BlueWing Airlines Headquarters, Blue Plaza, City", LocalDateTime.now(), 88, "https://bluewing.com/logo.png", "BlueWing Headquarters, Blue City", 200, "BlueWing Frequent Flyer", new BigDecimal("55000000"));
        Airline airline4 = new Airline("Sunrise Airways", 9999999990L, "contact@sunriseairways.com", "Sunrise Airways Building, Sunrise Street, Town", LocalDateTime.now(), 92, "https://sunriseairways.com/logo.png", "Sunrise Headquarters, Sunrise City", 150, "Sunrise Frequent Flyer", new BigDecimal("40000000"));
        Airline airline5 = new Airline("SilverCloud Airlines", 10101010100L, "customerservice@silvercloudairlines.com", "SilverCloud Tower, Cloud Avenue, Metropolis", LocalDateTime.now(), 87, "https://silvercloudairlines.com/logo.png", "SilverCloud Headquarters, Cloud City", 180, "SilverCloud Frequent Flyer", new BigDecimal("48000000"));
        Airline airline6 = new Airline("Royal Skies Aviation", 11111111110L, "info@royalskiesaviation.com", "Royal Skies Headquarters, Aviation Street, Capital City", LocalDateTime.now(), 95, "https://royalskiesaviation.com/logo.png", "Royal Skies Headquarters, Capital City", 220, "Royal Skies Frequent Flyer", new BigDecimal("75000000"));
        Airline airline7 = new Airline("Emerald Airways", 12121212120L, "contactus@emeraldairways.com", "Emerald Tower, Aviation Road, Emerald City", LocalDateTime.now(), 89, "https://emeraldairways.com/logo.png", "Emerald Headquarters, Emerald City", 130, "Emerald Frequent Flyer", new BigDecimal("43000000"));

        airlineRepository.save(airline1);
        airlineRepository.save(airline2);
        airlineRepository.save(airline3);
        airlineRepository.save(airline4);
        airlineRepository.save(airline5);
        airlineRepository.save(airline6);
        airlineRepository.save(airline7);


        // Creating Flight objects
        Flight flight1 = new Flight("AA1001", "Los Angeles", "New York", 300, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 1, 8, 0), LocalDateTime.of(2025, 5, 1, 12, 0), 300.0, 150,
                FlightStatus.ON_TIME, 50.0, airline1.getId(), airport1.getId(), airport2.getId());

        Flight flight2 = new Flight("AA1002", "Atlanta", "San Francisco", 330, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 2, 9, 0), LocalDateTime.of(2025, 5, 2, 14, 0), 350.0, 160,
                FlightStatus.ON_TIME, 55.0, airline2.getId(), airport2.getId(), airport9.getId());

        Flight flight3 = new Flight("AA1003", "Dubai", "Los Angeles", 960, FlightType.NON_STOP,
                LocalDateTime.of(2025, 5, 3, 1, 0), LocalDateTime.of(2025, 5, 3, 17, 0), 1200.0, 220,
                FlightStatus.DELAYED, 85.0, airline3.getId(), airport11.getId(), airport1.getId());

        Flight flight4 = new Flight("AA1004", "Toronto", "Chicago", 120, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 4, 13, 30), LocalDateTime.of(2025, 5, 4, 15, 30), 200.0, 140,
                FlightStatus.ON_TIME, 40.0, airline4.getId(), airport6.getId(), airport10.getId());

        Flight flight5 = new Flight("AA1005", "Heathrow", "Delhi", 600, FlightType.NON_STOP,
                LocalDateTime.of(2025, 5, 5, 10, 0), LocalDateTime.of(2025, 5, 5, 20, 0), 900.0, 180,
                FlightStatus.CANCELLED, 65.0, airline5.getId(), airport7.getId(), airport3.getId());

        Flight flight6 = new Flight("AA1006", "Atlanta", "Denver", 180, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 6, 12, 30), LocalDateTime.of(2025, 5, 6, 15, 30), 280.0, 130,
                FlightStatus.ON_TIME, 48.0, airline6.getId(), airport2.getId(), airport8.getId());

        Flight flight7 = new Flight("AA1007", "Tokyo", "San Francisco", 600, FlightType.NON_STOP,
                LocalDateTime.of(2025, 5, 7, 6, 0), LocalDateTime.of(2025, 5, 7, 14, 0), 750.0, 200,
                FlightStatus.ON_TIME, 60.0, airline7.getId(), airport5.getId(), airport9.getId());

        Flight flight8 = new Flight("AA1008", "Frankfurt", "Abu Dhabi", 420, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 8, 22, 30), LocalDateTime.of(2025, 5, 9, 4, 30), 550.0, 160,
                FlightStatus.DELAYED, 70.0, airline1.getId(), airport15.getId(), airport4.getId());

        Flight flight9 = new Flight("AA1009", "Sydney", "Tokyo", 540, FlightType.NON_STOP,
                LocalDateTime.of(2025, 5, 9, 9, 30), LocalDateTime.of(2025, 5, 9, 18, 0), 680.0, 190,
                FlightStatus.ON_TIME, 55.0, airline2.getId(), airport14.getId(), airport5.getId());

        Flight flight10 = new Flight("AA1010", "Chicago", "Singapore", 900, FlightType.NON_STOP,
                LocalDateTime.of(2025, 5, 10, 11, 0), LocalDateTime.of(2025, 5, 11, 2, 0), 1100.0, 230,
                FlightStatus.ON_TIME, 90.0, airline3.getId(), airport10.getId(), airport12.getId());

        // Creating Flight objects from 11 to 20
        Flight flight11 = new Flight("AA1011", "New York", "London", 420, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 11, 18, 0), LocalDateTime.of(2025, 5, 12, 0, 0), 700.0, 180,
                FlightStatus.ON_TIME, 80.0, airline4.getId(), airport2.getId(), airport7.getId());

        Flight flight12 = new Flight("AA1012", "Los Angeles", "Tokyo", 720, FlightType.NON_STOP,
                LocalDateTime.of(2025, 5, 12, 12, 30), LocalDateTime.of(2025, 5, 13, 6, 30), 850.0, 200,
                FlightStatus.ON_TIME, 90.0, airline5.getId(), airport1.getId(), airport5.getId());

        Flight flight13 = new Flight("AA1013", "Dubai", "Toronto", 840, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 13, 5, 0), LocalDateTime.of(2025, 5, 13, 19, 0), 1100.0, 210,
                FlightStatus.DELAYED, 85.0, airline6.getId(), airport11.getId(), airport6.getId());

        Flight flight14 = new Flight("AA1014", "Chicago", "New Delhi", 780, FlightType.NON_STOP,
                LocalDateTime.of(2025, 5, 14, 9, 0), LocalDateTime.of(2025, 5, 15, 10, 0), 1200.0, 220,
                FlightStatus.ON_TIME, 95.0, airline7.getId(), airport10.getId(), airport3.getId());

        Flight flight15 = new Flight("AA1015", "Sydney", "San Francisco", 660, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 15, 7, 30), LocalDateTime.of(2025, 5, 15, 18, 30), 880.0, 190,
                FlightStatus.ON_TIME, 75.0, airline1.getId(), airport14.getId(), airport9.getId());

        Flight flight16 = new Flight("AA1016", "Atlanta", "Dubai", 960, FlightType.NON_STOP,
                LocalDateTime.of(2025, 5, 16, 14, 0), LocalDateTime.of(2025, 5, 17, 6, 0), 1400.0, 250,
                FlightStatus.DELAYED, 100.0, airline2.getId(), airport2.getId(), airport11.getId());

        Flight flight17 = new Flight("AA1017", "Frankfurt", "Chicago", 540, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 17, 16, 0), LocalDateTime.of(2025, 5, 17, 23, 0), 750.0, 180,
                FlightStatus.ON_TIME, 80.0, airline3.getId(), airport15.getId(), airport10.getId());

        Flight flight18 = new Flight("AA1018", "Tokyo", "Frankfurt", 660, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 18, 10, 0), LocalDateTime.of(2025, 5, 18, 21, 0), 900.0, 200,
                FlightStatus.CANCELLED, 95.0, airline4.getId(), airport5.getId(), airport15.getId());

        Flight flight19 = new Flight("AA1019", "Abu Dhabi", "Heathrow", 480, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 19, 3, 30), LocalDateTime.of(2025, 5, 19, 11, 30), 600.0, 170,
                FlightStatus.ON_TIME, 70.0, airline5.getId(), airport4.getId(), airport7.getId());

        Flight flight20 = new Flight("AA1020", "Los Angeles", "Chicago", 240, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 20, 7, 0), LocalDateTime.of(2025, 5, 20, 11, 0), 400.0, 150,
                FlightStatus.ON_TIME, 65.0, airline6.getId(), airport1.getId(), airport10.getId());

        // Creating Flight objects from 21 to 25
        Flight flight21 = new Flight("AA1021", "San Francisco", "London", 660, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 21, 15, 0), LocalDateTime.of(2025, 5, 22, 3, 0), 900.0, 200,
                FlightStatus.ON_TIME, 85.0, airline7.getId(), airport9.getId(), airport7.getId());

        Flight flight22 = new Flight("AA1022", "New York", "Dubai", 720, FlightType.NON_STOP,
                LocalDateTime.of(2025, 5, 22, 9, 0), LocalDateTime.of(2025, 5, 23, 6, 0), 950.0, 210,
                FlightStatus.DELAYED, 100.0, airline1.getId(), airport2.getId(), airport11.getId());

        Flight flight23 = new Flight("AA1023", "Chicago", "Tokyo", 840, FlightType.DIRECT,
                LocalDateTime.of(2025, 5, 23, 10, 0), LocalDateTime.of(2025, 5, 24, 6, 0), 1050.0, 230,
                FlightStatus.ON_TIME, 90.0, airline2.getId(), airport10.getId(), airport5.getId());

        Flight flight24 = new Flight("AA1024", "Toronto", "Paris", 420, FlightType.NON_STOP,
                LocalDateTime.of(2025, 5, 24, 16, 30), LocalDateTime.of(2025, 5, 25, 0, 30), 700.0, 180,
                FlightStatus.CANCELLED, 70.0, airline3.getId(), airport6.getId(), airport8.getId());

        Flight flight25 = new Flight("AA1025", "Los Angeles", "Sydney", 960, FlightType.NON_STOP,
                LocalDateTime.of(2025, 5, 25, 22, 0), LocalDateTime.of(2025, 5, 26, 12, 0), 1300.0, 250,
                FlightStatus.ON_TIME, 110.0, airline4.getId(), airport1.getId(), airport14.getId());

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

        Passenger passenger1 = new Passenger(
                "John", "Doe", 1234567890L, "john.doe@example.com",
                "123 Main St, Anytown", "AB123456", "USA",
                LocalDate.of(1985, 6, 15), GenderType.MALE,
                "None", "Mary Doe", 1112223333L, "Wife"
        );

        Passenger passenger2 = new Passenger(
                "Jane", "Smith", 9876543210L, "jane.smith@example.com",
                "456 Oak Ave, Othercity", "CD987654", "UK",
                LocalDate.of(1990, 8, 25), GenderType.FEMALE,
                "Wheelchair assistance required", "John Smith", 4445556666L, "Husband"
        );

        Passenger passenger3 = new Passenger(
                "Michael", "Johnson", 5555555555L, "michael.johnson@example.com",
                "789 Elm St, Anothercity", "EF555555", "Canada",
                LocalDate.of(1970, 4, 10), GenderType.MALE,
                "Sign language interpreter required", "Sarah Johnson", 7778889999L, "Daughter"
        );

        Passenger passenger4 = new Passenger(
                "Emily", "Williams", 3333333333L, "emily.williams@example.com",
                "321 Pine St, Yetanothercity", "GH333333", "Australia",
                LocalDate.of(1988, 9, 5), GenderType.FEMALE,
                "Braille signage required", "Robert Williams", 2223334444L, "Brother"
        );

        Passenger passenger5 = new Passenger(
                "David", "Brown", 4444444444L, "david.brown@example.com",
                "567 Maple St, Finalcity", "IJ444444", "Germany",
                LocalDate.of(1982, 3, 20), GenderType.MALE,
                "Service animals permitted", "Lisa Brown", 5556667777L, "Sister"
        );


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

