package com.rnagaraju.goflights.model;

/**
 * Enumeration representing different gender types.
 * Each type has a corresponding label.
 * @author rahul
 */
public enum GenderType {

    /**
     * Male gender type.
     */
    MALE("Male"),

    /**
     * Female gender type.
     */
    FEMALE("Female"),

    /**
     * Transgender gender type.
     */
    OTHERS("Transgender"),

    /**
     * Not applicable gender type.
     */
    NA("Don't Specify");

    private String label;

    private GenderType(String label) {
        this.label = label;
    }

    /**
     * Getter for the label of the gender type.
     * @return The label of the gender type.
     */
    public String getLabel(){
        return label;
    }
}
