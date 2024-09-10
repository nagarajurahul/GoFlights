package com.rnagaraju.goflights.dto;

import com.rnagaraju.goflights.model.GenderType;

import java.time.LocalDate;

public class PassengerDTO {
    private String firstName;
    private String lastName;
    private Long mobileNumber;
    private String emailId;
    private String address;
    private String passportNumber;
    private String nationality;
    private LocalDate birthDate;
    private String genderType;

    public PassengerDTO() {
    }

    public PassengerDTO(String firstName, String lastName, Long mobileNumber, String emailId, String address, String passportNumber, String nationality, LocalDate birthDate, String genderType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.address = address;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.genderType = genderType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    @Override
    public String toString() {
        return "PassengerDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", emailId='" + emailId + '\'' +
                ", address='" + address + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate=" + birthDate +
                ", genderType='" + genderType + '\'' +
                '}';
    }
}
