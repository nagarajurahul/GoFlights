package com.rnagaraju.goflights.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Abstract base class providing common attributes for entities in the system.
 * @author rahul
 */
@MappedSuperclass
public class AbstractEntity {

    /**
     * The unique identifier for the entity.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    protected Long id;

    /**
     * The version number of the entity.
     */
    @Version
    private Long version;

    /**
     * The timestamp when the entity was created.
     */
    @Column(name="CREATED_TIMESTAMP")
    private LocalDateTime createdTimestamp;

    /**
     * The timestamp when the entity was last modified.
     */
    @Column(name="MODIFIED_TIMESTAMP")
    private LocalDateTime modifiedTimestamp;

    /**
     * Indicates whether the entity has been logically deleted.
     */
    @Column(name = "deleted")
    private boolean deleted;

    /**
     * Initializes the created timestamp before persisting the entity.
     */
    @PrePersist
    public void initializeCreatedTimeStamp(){
        this.createdTimestamp=LocalDateTime.now();
    }

    /**
     * Updates the modified timestamp before updating the entity.
     */
    @PreUpdate
    public void initializeModifiedTimeStamp(){
        this.modifiedTimestamp=LocalDateTime.now();
    }

    /**
     * Retrieves the unique identifier of the entity.
     *
     * @return The unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the entity.
     *
     * @param id The unique identifier.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the version number of the entity.
     *
     * @return The version number.
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version number of the entity.
     *
     * @param version The version number.
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * Retrieves the timestamp when the entity was created.
     *
     * @return The created timestamp.
     */
    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     * Sets the timestamp when the entity was created.
     *
     * @param createdTimestamp The created timestamp.
     */
    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    /**
     * Retrieves the timestamp when the entity was last modified.
     *
     * @return The modified timestamp.
     */
    public LocalDateTime getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    /**
     * Sets the timestamp when the entity was last modified.
     *
     * @param modifiedTimestamp The modified timestamp.
     */
    public void setModifiedTimestamp(LocalDateTime modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }

    /**
     * Checks if the entity has been logically deleted.
     *
     * @return True if the entity is deleted, false otherwise.
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Sets the deletion status of the entity.
     *
     * @param deleted True to mark the entity as deleted, false otherwise.
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
