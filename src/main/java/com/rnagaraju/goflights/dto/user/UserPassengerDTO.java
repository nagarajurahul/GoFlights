package com.rnagaraju.goflights.dto.user;

import java.time.LocalDate;

public class UserPassengerDTO{
    private Long id;
    private String firstName;
    private String lastName;
    private Long mobileNumber;
    private String emailId;
    private String address;
    private String passportNumber;
    private String nationality;
    private LocalDate birthDate;
    private String genderType;
    private String specialAssistanceRequirements;
    private String emergencyContactName;
    private Long emergencyContactNumber;
    private String emergencyContactRelation;

    public UserPassengerDTO() {
    }

    public UserPassengerDTO(String firstName, String lastName,
                            Long mobileNumber, String emailId, String address,
                            String passportNumber, String nationality,
                            LocalDate birthDate, String genderType) {
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

    public UserPassengerDTO(Long id, String firstName, String lastName, Long mobileNumber, String emailId, String address, String passportNumber, String nationality, LocalDate birthDate, String genderType, String specialAssistanceRequirements, String emergencyContactName, Long emergencyContactNumber, String emergencyContactRelation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.address = address;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.genderType = genderType;
        this.specialAssistanceRequirements = specialAssistanceRequirements;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNumber = emergencyContactNumber;
        this.emergencyContactRelation = emergencyContactRelation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSpecialAssistanceRequirements() {
        return specialAssistanceRequirements;
    }

    public void setSpecialAssistanceRequirements(String specialAssistanceRequirements) {
        this.specialAssistanceRequirements = specialAssistanceRequirements;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public Long getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(Long emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getEmergencyContactRelation() {
        return emergencyContactRelation;
    }

    public void setEmergencyContactRelation(String emergencyContactRelation) {
        this.emergencyContactRelation = emergencyContactRelation;
    }
}
