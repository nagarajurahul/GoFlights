package com.rnagaraju.goflights.model;

/**
 * Enumeration representing different types of flights.
 * Each type has a corresponding label.
 * @author rahul
 */
public enum FlightType {

    /**
     * Direct flight type.
     */
    DIRECT("Direct"),

    /**
     * Non-stop flight type.
     */
    NON_STOP("Non Stop"),

    /**
     * Connecting flight type.
     */
    CONNECTING("Connecting");

    private String label;

    private FlightType(String label) {
        this.label = label;
    }

    /**
     * Getter for the label of the flight type.
     * @return The label of the flight type.
     */
    public String getLabel(){
        return label;
    }
}
