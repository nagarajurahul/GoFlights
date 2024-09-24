package com.rnagaraju.goflights.exception;


public class FlightAlreadyCancelledException extends RuntimeException {
    public FlightAlreadyCancelledException(String s) {
        super(s);
    }
    public FlightAlreadyCancelledException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
