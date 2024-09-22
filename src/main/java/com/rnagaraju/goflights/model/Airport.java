package com.rnagaraju.goflights.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
//@Table(name="AIRPORT_TABLE")
public class Airport extends AbstractEntity {

    @NotBlank
    @Column(name="AIRPORT_NAME",nullable=false,unique=true)
    private String airportName;

    @NotBlank
    @Column(name="AIRPORT_LOCATION")
    private String location;

    @NotBlank
    @Column(name="AIRPORT_TIME_ZONE")
    private String timeZone;

    @NotNull
    @Column(name="AIRPORT_TOTAL_EMPLOYEES")
    private Integer totalEmployees;

    @PastOrPresent
    @Column(name="AIRPORT_ESTABLISHMENT_DATE")
    private LocalDateTime establishmentDate;

    @NotBlank
    @Column(name="AIRPORT_CODE")
    private String airportCode;

    @NotNull
    @Column(name="AIRPORT_CONTACT")
    private Long contact;

    @Column(name="AIRPORT_EMAIL")
    private String email;

    @Column(name="AIRPORT_ACCESSBILITY_FEATURES")
    private String accessibilityFeatures;

    @NotNull
    @Min(1)
    @Column(name="AIRPORT_RUNWAY_COUNT")
    private Integer runwayCount;

    @NotNull
    @Min(1)
    @Column(name="AIRPORT_TERMINAL_COUNT")
    private Integer terminalCount;

    @NotNull
    @Column(name="AIRPORT_ANNUAL_REVENUE")
    private BigDecimal annualRevenue;

    @NotNull
    @DecimalMin("0.0")
    @Column(name="AIRPORT_AVERAGE_FLIGHT_DELAY")
    private Double averageFlightDelay;

    public Airport() {
    }

    public Airport(String airportName, String location, String timeZone, Integer totalEmployees, LocalDateTime establishmentDate) {
        this.airportName = airportName;
        this.location = location;
        this.timeZone = timeZone;
        this.totalEmployees = totalEmployees;
        this.establishmentDate = establishmentDate;
    }

    public Airport(String airportName, String location, String timeZone, Integer totalEmployees, LocalDateTime establishmentDate, String airportCode, Long contact, String email, String accessibilityFeatures) {
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

    public Airport(String airportName, String location, String timeZone, Integer totalEmployees, LocalDateTime establishmentDate, String airportCode, Long contact, String email, String accessibilityFeatures, Integer runwayCount, Integer terminalCount, BigDecimal annualRevenue, Double averageFlightDelay) {
        this.airportName = airportName;
        this.location = location;
        this.timeZone = timeZone;
        this.totalEmployees = totalEmployees;
        this.establishmentDate = establishmentDate;
        this.airportCode = airportCode;
        this.contact = contact;
        this.email = email;
        this.accessibilityFeatures = accessibilityFeatures;
        this.runwayCount = runwayCount;
        this.terminalCount = terminalCount;
        this.annualRevenue = annualRevenue;
        this.averageFlightDelay = averageFlightDelay;
    }

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

    public Integer getRunwayCount() {
        return runwayCount;
    }

    public void setRunwayCount(Integer runwayCount) {
        this.runwayCount = runwayCount;
    }

    public Integer getTerminalCount() {
        return terminalCount;
    }

    public void setTerminalCount(Integer terminalCount) {
        this.terminalCount = terminalCount;
    }

    public BigDecimal getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(BigDecimal annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public Double getAverageFlightDelay() {
        return averageFlightDelay;
    }

    public void setAverageFlightDelay(Double averageFlightDelay) {
        this.averageFlightDelay = averageFlightDelay;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", airportName='" + airportName + '\'' +
                ", location='" + location + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", totalEmployees=" + totalEmployees +
                ", establishmentDate=" + establishmentDate +
                ", airportCode='" + airportCode + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", accessibilityFeatures='" + accessibilityFeatures + '\'' +
                ", runwayCount=" + runwayCount + '\'' +
                ", terminalCount=" + terminalCount + '\'' +
                ", annualRevenue=" + annualRevenue + '\'' +
                ", averageFlightDelay=" + averageFlightDelay + '\'' +
                '}';
    }
}
