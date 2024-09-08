package com.rnagaraju.goflights.model;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.rnagaraju.goflights.security.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/**
 * Entity representing a passenger with necessary and helpful fields.
 * Each passenger has associated bookings, user, and other personal information.
 * @author rahul
 */
@Entity
//@Table(name="PASSENGER_TABLE")
@NamedQuery(name="Passenger.findAll",query="select passenger from Passenger passenger where passenger.deleted = false")
@NamedQuery(name = "Passenger.findByUsername", query="select passenger from Passenger passenger where passenger.user.userName = :uname and passenger.deleted = false")
@NamedQuery(name="Passenger.findByOwner",query="select passenger from Passenger passenger where passenger.owner= :owner and passenger.deleted = false")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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



    /*
     * This is the inverse(non-owning) side in Booking:Passenger relationship
     * Hence adding mapped by here
     */

    //@OneToMany(mappedBy = "passenger",fetch=FetchType.LAZY)
    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings=new ArrayList<>();

    @OneToOne
    @JoinColumn(name="USERNAME")
    private User user;

    @Column(name="PASSENGER_SPECIAL_ASSISTANCE_REQUIREMENTS")
    private String specialAssistanceRequirements;

    @Column(name="OWNER")
    private String owner;


    // This constructor needed when there is no flight info or booking id yet

    /**
     * Constructs a passenger with basic personal information.
     * @param firstName The first name of the passenger.
     * @param lastName The last name of the passenger.
     * @param mobileNumber The mobile number of the passenger.
     * @param emailId The email id of the passenger.
     * @param address The address of the passenger.
     * @param passportNumber The passport number of the passenger.
     * @param nationality The nationality of the passenger.
     * @param birthDate The birth date of the passenger.
     */
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

    /**
     * Constructs a passenger with all personal information including owner.
     * @param firstName The first name of the passenger.
     * @param lastName The last name of the passenger.
     * @param mobileNumber The mobile number of the passenger.
     * @param emailId The email id of the passenger.
     * @param address The address of the passenger.
     * @param passportNumber The passport number of the passenger.
     * @param nationality The nationality of the passenger.
     * @param birthDate The birth date of the passenger.
     * @param owner The owner of the passenger.
     */
    public Passenger(String firstName, String lastName, Long mobileNumber, String emailId, String address, String passportNumber, String nationality, LocalDate birthDate, String owner) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailId=emailId;
        this.address = address;
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.owner=owner;
    }

    /**
     * Default constructor for Passenger.
     */
    public Passenger() {
    }

    /**
     * Retrieves the first name of the passenger.
     * @return The first name of the passenger.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the passenger.
     * @param firstName The first name of the passenger.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the passenger.
     * @return The last name of the passenger.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the passenger.
     * @param lastName The last name of the passenger.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the mobile number of the passenger.
     * @return The mobile number of the passenger.
     */
    public Long getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Sets the mobile number of the passenger.
     * @param mobileNumber The mobile number of the passenger.
     */
    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * Retrieves the email id of the passenger.
     * @return The email id of the passenger.
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email id of the passenger.
     * @param emailId The email id of the passenger.
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Retrieves the address of the passenger.
     * @return The address of the passenger.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the passenger.
     * @param address The address of the passenger.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves the passport number of the passenger.
     * @return The passport number of the passenger.
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * Sets the passport number of the passenger.
     * @param passportNumber The passport number of the passenger.
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    /**
     * Retrieves the nationality of the passenger.
     * @return The nationality of the passenger.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality of the passenger.
     * @param nationality The nationality of the passenger.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * Retrieves the birth date of the passenger.
     * @return The birth date of the passenger.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birth date of the passenger.
     * @param birthDate The birth date of the passenger.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Generates the hash code for the passenger.
     * @return The hash code for the passenger.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Compares if this passenger is equal to another object.
     * @param obj The object to compare to.
     * @return True if this passenger is equal to the other object, otherwise false.
     */
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

    /**
     * Retrieves the list of bookings associated with this passenger.
     * @return The list of bookings associated with this passenger.
     */
    public List<Booking> getBookings() {
        return bookings;
    }

    /**
     * Sets the list of bookings associated with this passenger.
     * @param bookings The list of bookings associated with this passenger.
     */
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * Retrieves the gender type of the passenger.
     * @return The gender type of the passenger.
     */
    public GenderType getGenderType() {
        return genderType;
    }

    /**
     * Sets the gender type of the passenger.
     * @param genderType The gender type of the passenger.
     */
    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    // Just helper method to get all attributes in a Map

    /**
     * Retrieves all attributes of the passenger as a map.
     * @return All attributes of the passenger as a map.
     */
    public Map<String, Object> getAttributesAsMap() {
        Map<String, Object> attributesMap = new HashMap<>();
        attributesMap.put("id", id);
        attributesMap.put("version", this.getVersion());
        attributesMap.put("createdTimestamp", this.getCreatedTimestamp());
        attributesMap.put("modifiedTimestamp", this.getModifiedTimestamp());
        attributesMap.put("firstName", firstName);
        attributesMap.put("lastName", lastName);
        attributesMap.put("mobileNumber", mobileNumber);
        attributesMap.put("emailId", emailId);
        attributesMap.put("address", address);
        attributesMap.put("passportNumber", passportNumber);
        attributesMap.put("nationality", nationality);
        attributesMap.put("birthDate", birthDate);
        attributesMap.put("genderType", genderType);
        return attributesMap;
    }

    /**
     * Retrieves the user associated with this passenger.
     * @return The user associated with this passenger.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with this passenger.
     * @param user The user associated with this passenger.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Retrieves the special assistance requirements of the passenger.
     * @return The special assistance requirements of the passenger.
     */
    public String getSpecialAssistanceRequirements() {
        return specialAssistanceRequirements;
    }

    /**
     * Sets the special assistance requirements of the passenger.
     * @param specialAssistanceRequirements The special assistance requirements of the passenger.
     */
    public void setSpecialAssistanceRequirements(String specialAssistanceRequirements) {
        this.specialAssistanceRequirements = specialAssistanceRequirements;
    }

    /**
     * Retrieves the owner of the passenger.
     * @return The owner of the passenger.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the passenger.
     * @param owner The owner of the passenger.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Generates a string representation of the passenger.
     * @return A string representation of the passenger.
     */
    @Override
    public String toString() {
        return "Passenger{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", address=" + address + ", passportNumber=" + passportNumber + ", nationality=" + nationality + ", birthDate=" + birthDate + ", genderType=" + genderType + ", specialAssistanceRequirements=" + specialAssistanceRequirements + '}';
    }

}
