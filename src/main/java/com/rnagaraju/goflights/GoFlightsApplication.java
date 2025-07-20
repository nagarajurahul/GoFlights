package com.rnagaraju.goflights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoFlightsApplication {
    public static void main(String[] args) {
          // To debug and check configuration in development
          // Never do this hasty task in production :-)
//        System.out.println("========== EARLY ENV CHECK ==========");
//        System.out.println("DB_URL: " + System.getenv("DB_URL"));
//        System.out.println("DB_USER: " + System.getenv("DB_USER"));
//        System.out.println("DB_PASSWORD: " + System.getenv("DB_PASSWORD"));
//        System.out.println("=====================================");

        SpringApplication.run(GoFlightsApplication.class, args);
    }
}
