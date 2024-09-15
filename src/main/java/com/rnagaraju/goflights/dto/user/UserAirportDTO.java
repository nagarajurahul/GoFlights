package com.rnagaraju.goflights.dto.user;

import java.time.LocalDateTime;

public class UserAirportDTO {

    private String airportName;
    private String location;
    private String timeZone;
    private Integer totalEmployees;
    private LocalDateTime establishmentDate;
    private String airportCode;
    private Long contact;
    private String email;
    private String accessibilityFeatures;

    // Default constructor
    public UserAirportDTO() {
    }

    // Parameterized constructor
    public UserAirportDTO(String airportName, String location, String timeZone,
                          Integer totalEmployees, LocalDateTime establishmentDate,
                          String airportCode, Long contact, String email,
                          String accessibilityFeatures) {
        this.airportName = airportName;
        this.location = location;
        this.timeZone = timeZone;
        this.totalEmployees = totalEmployees;
        this.establishmentDate = establishmentDate;
        this.airportCode = airportCode;
        this.contact = contact;
        this.email = email;
        this.accessibilityFeatures = accessibilityFeatures;
    }

    // Getters and Setters

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Integer getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(Integer totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public LocalDateTime getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(LocalDateTime establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessibilityFeatures() {
        return accessibilityFeatures;
    }

    public void setAccessibilityFeatures(String accessibilityFeatures) {
        this.accessibilityFeatures = accessibilityFeatures;
    }

    @Override
    public String toString() {
        return "AirportDTO{" +
                "airportName='" + airportName + '\'' +
                ", location='" + location + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", totalEmployees=" + totalEmployees +
                ", establishmentDate=" + establishmentDate +
                ", airportCode='" + airportCode + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", accessibilityFeatures='" + accessibilityFeatures + '\'' +
                '}';
    }
}
