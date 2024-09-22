package com.rnagaraju.goflights.model;

public enum FlightStatus {
    SCHEDULED("Scheduled"),
    ON_TIME("On Time"),
    DELAYED("Delayed"),
    IN_FLIGHT("In Flight"),
    LANDED("Landed"),
    CANCELLED("Cancelled"),
    BOARDING("Boarding"),
    DIVERTED("Diverted"),
    GROUNDED("Grounded"),
    RETURN_TO_GATE("Return to Gate"),
    FINAL_CALL("Final Call"),
    CLOSED("Closed"),
    UNKNOWN("Unknown");

    private final String status;

    FlightStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }

    public static FlightStatus fromString(String status) {
        for (FlightStatus flightStatus : FlightStatus.values()) {
            if (flightStatus.getStatus().equalsIgnoreCase(status)) {
                return flightStatus;
            }
        }
        throw new IllegalArgumentException("No enum constant for status: " + status);
    }

}
