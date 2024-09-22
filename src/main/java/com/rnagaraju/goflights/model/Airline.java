package com.rnagaraju.goflights.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
//@Table(name="AIRLINE_TABLE")
public class Airline extends AbstractEntity{

    @NotBlank
    @Column(name="AIRLINE_NAME")
    private String airlineName;

    @NotNull
    @Min(1000000000)
    @Column(name="AIRLINE_CONTACT")
    private Long contact;

    @Email
    @Column(name="AIRLINE_EMAIL")
    private String email;

    @NotBlank
    @Column(name="AIRLINE_ADDRESS")
    private String address;

    @PastOrPresent
    @Column(name="AIRLINE_CERTIFICATION_DATE_TIME")
    private LocalDateTime certificationDateTime;

    @Column(name="AIRLINE_CUSTOMER_REVIEWS")
    private Integer customerReviews;

    @Column(name="AIRLINE_LOGO_URL")
    private String logoUrl;

    @NotBlank
    @Column(name="AIRLINE_HEADQUARTERS")
    private String headquarters;

    @NotNull
    @Min(1)
    @Column(name="AIRLINE_EMPLOYEES")
    private Integer totalEmployees;

    @Column(name="AIRLINE_FREQUENT_FLYER_PROGRAM")
    private String frequentFlyerProgram;

    @Column(name="AIRLINE_ANNUAL_REVENUE")
    private BigDecimal annualRevenue;

    public Airline() {
    }

    public Airline(String airlineName, Long contact, String email, String address, LocalDateTime certificationDateTime) {
        this.airlineName = airlineName;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.certificationDateTime = certificationDateTime;
    }

    public Airline(String airlineName, Long contact, String email, String address, LocalDateTime certificationDateTime, Integer customerReviews, String logoUrl, String headquarters, Integer totalEmployees, String frequentFlyerProgram, BigDecimal annualRevenue) {
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

    public @NotBlank String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(@NotBlank String headquarters) {
        this.headquarters = headquarters;
    }

    public @NotNull @Min(1) Integer getTotalEmployees() {
        return totalEmployees;
    }

    public void setTotalEmployees(@NotNull @Min(1) Integer totalEmployees) {
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
                ", logoUrl='" + logoUrl + '\'' +
                ", headquarters='" + headquarters + '\'' +
                ", totalEmployees=" + totalEmployees +
                ", frequentFlyerProgram='" + frequentFlyerProgram + '\'' +
                ", annualRevenue=" + annualRevenue + '\'' +
                '}';
    }


}


