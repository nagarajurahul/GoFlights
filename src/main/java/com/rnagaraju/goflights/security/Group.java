package com.rnagaraju.goflights.security;

/*
 * Group.java
 *
 * Represents a group in the security system.
 * Author: rahul
 */

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Group
 *
 * Represents a group in the security system.
 * Author: rahul
 */
@Entity
@Table(name="SEC_GROUP")
@NamedQuery(name="Group.findAll",query="select g from Group g")
@NamedQuery(name="Group.findByGroupName",query="select g from Group g where g.groupName = :gname")
public class Group {

    /**
     * The name of the group.
     */
    @Id
    private String groupName;

    /**
     * The description of the group.
     */
    private String groupDescription;

    /**
     * The list of users belonging to the group.
     * This is the inverse side of the many-to-many relationship between User and Group.
     */
    @ManyToMany(mappedBy="groups")
    private List<User> users=new ArrayList<>();

    /**
     * Constructs a new Group instance.
     */
    public Group() {
    }

    /**
     * Constructs a new Group instance with the specified name and description.
     *
     * @param groupName The name of the group.
     * @param groupDescription The description of the group.
     */
    public Group(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }


    /**
     * Retrieves the name of the group.
     *
     * @return The name of the group.
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the name of the group.
     *
     * @param groupName The name of the group.
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Retrieves the description of the group.
     *
     * @return The description of the group.
     */
    public String getGroupDescription() {
        return groupDescription;
    }

    /**
     * Sets the description of the group.
     *
     * @param groupDescription The description of the group.
     */
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    /**
     * Retrieves the list of users belonging to the group.
     *
     * @return The list of users.
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Sets the list of users belonging to the group.
     *
     * @param users The list of users.
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

}
