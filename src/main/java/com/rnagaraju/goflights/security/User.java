package com.rnagaraju.goflights.security;

/*
 * User.java
 *
 * Represents a user in the security system.
 * @author rahul
 */

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * User
 *
 * Represents a user in the security system.
 * @author rahul
 */
//@Entity
//@Table(name="SEC_USER")
//@EntityListeners(UserPasswordHash.class)
//@NamedQuery(name="User.findAll",query="select u from User u")
public class User {

    /**
     * The username of the user.
     */
    @Id
    @NotBlank(message="Please enter a username")
    private String userName;

    /**
     * The password of the user.
     */
    @NotBlank(message="Please enter a password")
    private String password;

    /**
     * The groups that the user belongs to.
     */
    @ManyToMany
    @JoinTable(name="SEC_USER_GROUPS",
            joinColumns=@JoinColumn(name="USERNAME"),
            inverseJoinColumns=@JoinColumn(name="GROUPNAME"))
    private List<Group> groups=new ArrayList<>();

    /**
     * Constructs a new User instance.
     */
    public User() {
    }

    /**
     * Constructs a new User instance with the specified username and password.
     *
     * @param userName The username of the user.
     * @param password The password of the user.
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Helper methods

    /**
     * Adds a group to the list of groups that the user belongs to.
     *
     * @param g The group to add.
     */
    public void addGroup(Group g){
        this.groups.add(g);
        g.getUsers().add(this);
    }

    /**
     * Removes a group from the list of groups that the user belongs to.
     *
     * @param g The group to remove.
     */
    public void removeGroup(Group g){
        this.groups.remove(g);
        g.getUsers().remove(this);
    }

    /**
     * Retrieves the username of the user.
     *
     * @return The username of the user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the user.
     *
     * @param userName The username of the user.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the list of groups that the user belongs to.
     *
     * @return The list of groups.
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Sets the list of groups that the user belongs to.
     *
     * @param groups The list of groups.
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /**
     * Returns a string representation of the User object.
     *
     * @return A string representation of the User object.
     */
    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", password=" + password + '}';
    }

}

