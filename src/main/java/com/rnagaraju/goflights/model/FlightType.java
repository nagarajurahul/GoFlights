package com.rnagaraju.goflights.model;

public enum FlightType {

    DIRECT("Direct"),
    NON_STOP("Non Stop"),
    CONNECTING("Connecting");

    private final String type;

    private FlightType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public static FlightType fromString(String status) {
        for (FlightType flightType : FlightType.values()) {
            if (flightType.getType().equalsIgnoreCase(status)) {
                return flightType;
            }
        }
        throw new IllegalArgumentException("No enum constant for status: " + status);
    }
}
