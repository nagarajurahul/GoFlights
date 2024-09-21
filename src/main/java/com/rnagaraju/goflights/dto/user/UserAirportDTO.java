package com.rnagaraju.goflights.dto.user;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UserAirportDTO {
    private Long id;
    private String airportName;
    private String location;
    private String timeZone;
    private Integer totalEmployees;
    private LocalDateTime establishmentDate;
    private String airportCode;
    private Long contact;
    private String email;
    private String accessibilityFeatures;
    private Integer runwayCount;
    private Integer terminalCount;
    private BigDecimal annualRevenue;
    private Double averageFlightDelay;

    public UserAirportDTO() {
    }

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

    public UserAirportDTO(Long id, String airportName, String location, String timeZone, Integer totalEmployees, LocalDateTime establishmentDate, String airportCode, Long contact, String email, String accessibilityFeatures, Integer runwayCount, Integer terminalCount, BigDecimal annualRevenue, Double averageFlightDelay) {
        this.id=id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
