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
}
