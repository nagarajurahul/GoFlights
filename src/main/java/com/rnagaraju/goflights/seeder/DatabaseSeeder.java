package com.rnagaraju.goflights.seeder;

import com.rnagaraju.goflights.model.Flight;
import com.rnagaraju.goflights.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public void run(String... args) throws Exception {
        // Add 10 records to the goflights table
        for (int i = 1; i <= 10; i++) {
            Flight flight = new Flight();
            flight.setFlightName("Flight " + i);
            flight.setSource("City A" + i);
            flight.setDestination("City B" + i);
            flightRepository.save(flight);
        }

        System.out.println("Added 10 flight records to the database.");
    }
}

