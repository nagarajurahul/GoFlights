package com.rnagaraju.goflights.model;

public enum BookingStatus {
    CONFIRMED("Confirmed"),
    PENDING("Pending"),
    CANCELED("Canceled"),
    COMPLETED("Completed"),
    CHECKED_IN("Checked-In"),
    NO_SHOW("No Show"),
    REFUNDED("Refunded"),
    PARTIALLY_REFUNDED("Partially Refunded"),
    PAYMENT_PENDING("Payment Pending");

    private final String status;

    BookingStatus(String status) {
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