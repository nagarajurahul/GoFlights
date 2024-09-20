package com.rnagaraju.goflights.dto.common;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AirlineDTO {
    private String airlineName;
    private Long contact;
    private String email;
    private String address;
    private LocalDateTime certificationDateTime;
    private Integer customerReviews;
    private String logoUrl;
    private String headquarters;
    private Integer totalEmployees;
    private String frequentFlyerProgram;
    private BigDecimal annualRevenue;

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

    public AirlineDTO(String airlineName, Long contact, String email, String address, LocalDateTime certificationDateTime, Integer customerReviews, String logoUrl, String headquarters, Integer totalEmployees, String frequentFlyerProgram, BigDecimal annualRevenue) {
        this.airlineName = airlineName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.certificationDateTime = certificationDateTime;
        this.customerReviews = customerReviews;
        this.logoUrl = logoUrl;
        this.headquarters = headquarters;
        this.totalEmployees = totalEmployees;
        this.frequentFlyerProgram = frequentFlyerProgram;
        this.annualRevenue = annualRevenue;
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

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public Integer getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(Integer totalEmployees) {
        this.totalEmployees = totalEmployees;
    }

    public String getFrequentFlyerProgram() {
        return frequentFlyerProgram;
    }

    public void setFrequentFlyerProgram(String frequentFlyerProgram) {
        this.frequentFlyerProgram = frequentFlyerProgram;
    }

    public BigDecimal getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(BigDecimal annualRevenue) {
        this.annualRevenue = annualRevenue;
    }
}

