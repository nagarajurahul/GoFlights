package com.rnagaraju.goflights.model;

public enum FlightType {

    DIRECT("Direct"),
    NON_STOP("Non Stop"),
    CONNECTING("Connecting");

    private String label;

    private FlightType(String label) {
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
