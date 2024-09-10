package com.rnagaraju.goflights.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AirlineDTO {
    private String airlineName;
    private Long contact;
    private String email;
    private String address;
    private LocalDateTime certificationDateTime;
    private Integer customerReviews;
    private List<Long> flightIds;

    public AirlineDTO() {

    }

    public AirlineDTO(String airlineName, Long contact, String email, String address, LocalDateTime certificationDateTime, Integer customerReviews) {
        this.airlineName = airlineName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.certificationDateTime = certificationDateTime;
        this.customerReviews = customerReviews;
    }

    public AirlineDTO(String airlineName, Long contact, String email, String address, LocalDateTime certificationDateTime, Integer customerReviews, List<Long> flightIds) {
        this.airlineName = airlineName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.certificationDateTime = certificationDateTime;
        this.customerReviews = customerReviews;
        this.flightIds = flightIds;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCertificationDateTime() {
        return certificationDateTime;
    }

    public void setCertificationDateTime(LocalDateTime certificationDateTime) {
        this.certificationDateTime = certificationDateTime;
    }

    public Integer getCustomerReviews() {
        return customerReviews;
    }

    public void setCustomerReviews(Integer customerReviews) {
        this.customerReviews = customerReviews;
    }

    public List<Long> getFlightIds() {
        return flightIds;
    }

    public void setFlightIds(List<Long> flightIds) {
        this.flightIds = flightIds;
    }

    @Override
    public String toString() {
        return "AirlineDTO{" +
                "airlineName='" + airlineName + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", certificationDateTime=" + certificationDateTime +
                ", customerReviews=" + customerReviews +
                ", flightIds=" + flightIds +
                '}';
    }
}
