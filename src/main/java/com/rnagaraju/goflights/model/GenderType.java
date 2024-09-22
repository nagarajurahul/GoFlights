package com.rnagaraju.goflights.model;

public enum GenderType {

    MALE("Male"),
    FEMALE("Female"),
    OTHERS("Transgender"),
    NA("Don't Specify");

    private final String gender;

    GenderType(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return gender;
    }

    // Static method to get GenderType from a String
    public static GenderType fromString(String gender) {
        if (gender != null) {
            for (GenderType type : GenderType.values()) {
                if (type.getGender().equalsIgnoreCase(gender)) {
                    return type;
                }
            }
        }
        throw new IllegalArgumentException("No enum constant for gender: " + gender);
    }
}
