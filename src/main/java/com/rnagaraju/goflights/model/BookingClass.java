package com.rnagaraju.goflights.model;


public enum BookingClass {
    ECONOMY("Economy"),
    PREMIUM_ECONOMY("Premium Economy"),
    BUSINESS("Business"),
    FIRST_CLASS("First Class");

    private final String className;

    BookingClass(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return className;
    }
}