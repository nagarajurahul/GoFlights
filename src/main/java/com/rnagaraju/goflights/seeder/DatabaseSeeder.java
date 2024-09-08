package com.rnagaraju.goflights.seeder;

import com.rnagaraju.goflights.model.*;
import com.rnagaraju.goflights.repository.AirportRepository;
import com.rnagaraju.goflights.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

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




    }
}

