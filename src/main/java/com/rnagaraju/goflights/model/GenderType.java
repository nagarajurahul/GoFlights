package com.rnagaraju.goflights.model;

public enum GenderType {

    MALE("Male"),

    FEMALE("Female"),

    OTHERS("Transgender"),

    NA("Don't Specify");

    private String label;

    private GenderType(String label) {
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
