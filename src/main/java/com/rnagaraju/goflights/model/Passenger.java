package com.rnagaraju.goflights.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.NamedQuery;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;

@Entity
//@Table(name="PASSENGER_TABLE")
@NamedQuery(name="Passenger.findAll",query="select passenger from Passenger passenger where passenger.deleted = false")
@NamedQuery(name = "Passenger.findByUsername", query="select passenger from Passenger passenger where passenger.user.userName = :uname and passenger.deleted = false")
@NamedQuery(name="Passenger.findByOwner",query="select passenger from Passenger passenger where passenger.owner= :owner and passenger.deleted = false")
public class Passenger extends AbstractEntity {

    @NotBlank
    @Column(name="PASSENGER_FIRST_NAME")
    private String firstName;

    @NotBlank
    @Column(name="PASSENGER_LAST_NAME")
    private String lastName;

    @NotNull
    @Min(1000000000)
    @Column(name="PASSENGER_MOBILE_NUMBER")
    private Long mobileNumber;

    @Email
    @Column(name="PASSENGER_EMAIL_ID")
    private String emailId;


    @NotBlank
    @Column(name="PASSENGER_ADDRESS")
    private String address;

    @NotBlank
    @Column(name="PASSENGER_PASSPORT_NUMBER")
    private String passportNumber;

    @NotBlank
    @Column(name="PASSENGER_NATIONALITY")
    private String nationality;

    @PastOrPresent
    @Column(name="PASSENGER_BIRTHDATE")
    private LocalDate birthDate;


    @Enumerated(EnumType.STRING)
    @Column(name="GENDER_TYPE")
    private GenderType genderType;

    @Column(name="PASSENGER_SPECIAL_ASSISTANCE_REQUIREMENTS")
    private String specialAssistanceRequirements;

    @NotBlank
    @Column(name="PASSENGER_EMERGENCY_CONTACT_NAME")
    private String emergencyContactName;

    @NotNull
    @Min(1000000000)
    @Column(name="PASSENGER_EMERGENCY_CONTACT_NUMBER")
    private Long emergencyContactNumber;

    @NotBlank
    @Column(name="PASSENGER_EMERGENCY_CONTACT_RELATION")
    private String emergencyContactRelation;

    public Passenger() {
    }

    public Passenger(String firstName, String lastName, Long mobileNumber, String emailId, String address, String passportNumber, String nationality, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailId=emailId;
        this.address = address;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.birthDate = birthDate;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Passenger other = (Passenger) obj;
        if(this.id==null || other.id==null){
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
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
