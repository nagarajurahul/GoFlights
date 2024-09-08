package com.rnagaraju.goflights.model;

import edu.iit.sat.itmd4515.rnagaraju.security.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Airline entity representing an airline with necessary and helpful fields.
 * Each airline can operate multiple flights.
 * Each airline is associated with a user.
 * The entity is persisted in the database with JPA annotations.
 * @author rahul
 */
@Entity
//@Table(name="AIRLINE_TABLE")
@NamedQuery(name="Airline.findAll",query="select airline from Airline airline where airline.deleted = false")
@NamedQuery(name = "Airline.findByUsername", query="select airline from Airline airline where airline.user.userName= :uname and airline.deleted = false")
public class Airline extends AbstractEntity{

    /**
     * Name of the airline.
     */
    @NotBlank
    @Column(name="AIRLINE_NAME")
    private String airlineName;

    /**
     * Contact number of the airline.
     */
    @NotNull
    @Min(1000000000)
    @Column(name="AIRLINE_CONTACT")
    private Long contact;

    /**
     * Email of the airline.
     */
    @Email
    @Column(name="AIRLINE_EMAIL")
    private String email;

    /**
     * Address of the airline.
     */
    @NotBlank
    @Column(name="AIRLINE_ADDRESS")
    private String address;

    /**
     * Certification date and time of the airline.
     */
    @PastOrPresent
    @Column(name="AIRLINE_CERTIFICATION_DATE_TIME")
    private LocalDateTime certificationDateTime;

    /**
     * List of flights operated by the airline.
     */
    @OneToMany(mappedBy = "airline")
    private List<Flight> flights=new ArrayList<>();

    /**
     * User associated with the airline.
     */
    @OneToOne
    @JoinColumn(name="USERNAME")
    private User user;

    /**
     * Number of customer reviews for the airline.
     */
    @Column(name="AIRLINE_CUSTOMER_REVIEWS")
    private Integer customerReviews;

    /**
     * Default constructor for the Airline class.
     */
    public Airline() {
    }

    /**
     * Constructor for the Airline class with parameters.
     *
     * @param airlineName Name of the airline.
     * @param contact Contact number of the airline.
     * @param email Email of the airline.
     * @param address Address of the airline.
     * @param certificationDateTime Certification date and time of the airline.
     */
    public Airline(String airlineName, Long contact, String email, String address, LocalDateTime certificationDateTime) {
        this.airlineName = airlineName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.certificationDateTime = certificationDateTime;
    }

    /**
     * Constructor for the Airline class with parameters.
     *
     * @param airlineName Name of the airline.
     * @param contact Contact number of the airline.
     * @param email Email of the airline.
     * @param address Address of the airline.
     * @param certificationDateTime Certification date and time of the airline.
     * @param customerReviews Number of customer reviews for the airline.
     */
    public Airline(String airlineName, Long contact, String email, String address, LocalDateTime certificationDateTime, Integer customerReviews) {
        this.airlineName = airlineName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.certificationDateTime = certificationDateTime;
        this.customerReviews = customerReviews;
    }

    /**
     * Get the name of the airline.
     *
     * @return The name of the airline.
     */
    public String getAirlineName() {
        return airlineName;
    }

    /**
     * Set the name of the airline.
     *
     * @param airlineName The name of the airline.
     */
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    /**
     * Get the contact number of the airline.
     *
     * @return The contact number of the airline.
     */
    public Long getContact() {
        return contact;
    }

    /**
     * Set the contact number of the airline.
     *
     * @param contact The contact number of the airline.
     */
    public void setContact(Long contact) {
        this.contact = contact;
    }

    /**
     * Get the email of the airline.
     *
     * @return The email of the airline.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the airline.
     *
     * @param email The email of the airline.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the address of the airline.
     *
     * @return The address of the airline.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of the airline.
     *
     * @param address The address of the airline.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the certification date and time of the airline.
     *
     * @return The certification date and time of the airline.
     */
    public LocalDateTime getCertificationDateTime() {
        return certificationDateTime;
    }

    /**
     * Set the certification date and time of the airline.
     *
     * @param certificationDateTime The certification date and time of the airline.
     */
    public void setCertificationDateTime(LocalDateTime certificationDateTime) {
        this.certificationDateTime = certificationDateTime;
    }

    /**
     * Get the list of flights operated by the airline.
     *
     * @return The list of flights operated by the airline.
     */
    public List<Flight> getFlights() {
        return flights;
    }

    /**
     * Set the list of flights operated by the airline.
     *
     * @param flights The list of flights operated by the airline.
     */
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    /**
     * Get the user associated with the airline.
     *
     * @return The user associated with the airline.
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user associated with the airline.
     *
     * @param user The user associated with the airline.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get the number of customer reviews for the airline.
     *
     * @return The number of customer reviews for the airline.
     */
    public Integer getCustomerReviews() {
        return customerReviews;
    }

    /**
     * Set the number of customer reviews for the airline.
     *
     * @param customerReviews The number of customer reviews for the airline.
     */
    public void setCustomerReviews(Integer customerReviews) {
        this.customerReviews = customerReviews;
    }

    /**
     * Get a string representation of the Airline object.
     *
     * @return A string representation of the Airline object.
     */
    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", airlineName='" + airlineName + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", certificationDateTime=" + certificationDateTime +
                ", customerReviews=" + customerReviews +
                '}';
    }
}


