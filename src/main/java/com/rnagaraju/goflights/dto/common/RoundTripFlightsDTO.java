package com.rnagaraju.goflights.dto.common;

import java.util.List;

public class RoundTripFlightsDTO {

    private List<FlightDTO> outgoingFlights;
    private List<FlightDTO> returnFlights;

    public RoundTripFlightsDTO() {
    }

    public RoundTripFlightsDTO(List<FlightDTO> outgoingFlights, List<FlightDTO> returnFlights) {
        this.outgoingFlights = outgoingFlights;
        this.returnFlights = returnFlights;
    }

    public List<FlightDTO> getOutgoingFlights() {
        return outgoingFlights;
    }

    public void setOutgoingFlights(List<FlightDTO> outgoingFlights) {
        this.outgoingFlights = outgoingFlights;
    }

    public List<FlightDTO> getReturnFlights() {
        return returnFlights;
    }

    public void setReturnFlights(List<FlightDTO> returnFlights) {
        this.returnFlights = returnFlights;
    }
}