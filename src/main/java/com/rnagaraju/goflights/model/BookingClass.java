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

    // Static method to get BookingClass from a String
    public static BookingClass fromString(String className) {
        if (className != null) {
            for (BookingClass bookingClass : BookingClass.values()) {
                if (bookingClass.getClassName().equalsIgnoreCase(className)) {
                    return bookingClass;
                }
            }
        }
        throw new IllegalArgumentException("No enum constant for booking class: " + className);
    }
}