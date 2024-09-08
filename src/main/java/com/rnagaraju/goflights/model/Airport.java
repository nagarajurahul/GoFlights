package com.rnagaraju.goflights.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Airport entity representing an airport with necessary and helpful fields.
 * The entity is persisted in the database with JPA annotations.
 * @author rahul
 */
@Entity
@NamedQuery(name="Airport.findAll",query="select airport from Airport airport where airport.deleted = false")
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

    /**
     * Default constructor
     */
    public Airport() {
    }

    /**
     * Parameterized constructor
     * @param airportName The name of the airport
     * @param location The location of the airport
     * @param timeZone The time zone of the airport
     * @param totalEmployees The total number of employees at the airport
     * @param establishmentDate The establishment date of the airport
     */
    public Airport(String airportName, String location, String timeZone, Integer totalEmployees, LocalDateTime establishmentDate) {
        this.airportName = airportName;
        this.location = location;
        this.timeZone = timeZone;
        this.totalEmployees = totalEmployees;
        this.establishmentDate = establishmentDate;
    }

    /**
     * Parameterized constructor
     * @param airportName The name of the airport
     * @param location The location of the airport
     * @param timeZone The time zone of the airport
     * @param totalEmployees The total number of employees at the airport
     * @param establishmentDate The establishment date of the airport
     * @param airportCode The airport code
     * @param contact The contact number of the airport
     * @param email The email address of the airport
     * @param accessibilityFeatures The accessibility features of the airport
     */
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

    /**
     * Getter for airportName
     * @return The name of the airport
     */
    public String getAirportName() {
        return airportName;
    }

    /**
     * Setter for airportName
     * @param airportName The name of the airport
     */
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    /**
     * Getter for location
     * @return The location of the airport
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter for location
     * @param location The location of the airport
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Getter for timeZone
     * @return The time zone of the airport
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Setter for timeZone
     * @param timeZone The time zone of the airport
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * Getter for totalEmployees
     * @return The total number of employees at the airport
     */
    public Integer getTotalEmployees() {
        return totalEmployees;
    }

    /**
     * Setter for totalEmployees
     * @param totalEmployees The total number of employees at the airport
     */
    public void setTotalEmployees(Integer totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    /**
     * Getter for establishmentDate
     * @return The establishment date of the airport
     */
    public LocalDateTime getEstablishmentDate() {
        return establishmentDate;
    }

    /**
     * Setter for establishmentDate
     * @param establishmentDate The establishment date of the airport
     */
    public void setEstablishmentDate(LocalDateTime establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    /**
     * Getter for airportCode
     * @return The airport code
     */
    public String getAirportCode() {
        return airportCode;
    }

    /**
     * Setter for airportCode
     * @param airportCode The airport code
     */
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    /**
     * Getter for contact
     * @return The contact number of the airport
     */
    public Long getContact() {
        return contact;
    }

    /**
     * Setter for contact
     * @param contact The contact number of the airport
     */
    public void setContact(Long contact) {
        this.contact = contact;
    }

    /**
     * Getter for email
     * @return The email address of the airport
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email
     * @param email The email address of the airport
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for accessibilityFeatures
     * @return The accessibility features of the airport
     */
    public String getAccessibilityFeatures() {
        return accessibilityFeatures;
    }

    /**
     * Setter for accessibilityFeatures
     * @param accessibilityFeatures The accessibility features of the airport
     */
    public void setAccessibilityFeatures(String accessibilityFeatures) {
        this.accessibilityFeatures = accessibilityFeatures;
    }

    /**
     * toString method to represent Airport object as a string
     * @return String representation of the Airport object
     */
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
                '}';
    }
}
