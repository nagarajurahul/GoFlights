package com.rnagaraju.goflights.security;

import jakarta.inject.Inject;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;


/**
 * This class is responsible for hashing user passwords before persisting or updating user entities in the database.
 * @author rahul
 */

public class UserPasswordHash {

    @Inject
    private Pbkdf2PasswordHash hash;

    /**
     *
     */
    public UserPasswordHash() {
    }

    /*
     * hashPassword Method
     * Description: This method is called before persisting or updating a user entity in the database.
     * It hashes the user's password using the PBKDF2 (Password-Based Key Derivation Function 2) algorithm.
     * Parameters:
     * - User u: The user entity whose password needs to be hashed.
     * Implementation:
     * - The method retrieves the user's plaintext password using u.getPassword().
     * - It then generates a hash of the password using the generate() method of the injected Pbkdf2PasswordHash instance (hash).
     * - The hashed password replaces the plaintext password in the user entity using u.setPassword().
     */
    @PrePersist
    @PreUpdate
    private void hashPassword(User u){
        u.setPassword(hash.generate(u.getPassword().toCharArray()));
    }
}
