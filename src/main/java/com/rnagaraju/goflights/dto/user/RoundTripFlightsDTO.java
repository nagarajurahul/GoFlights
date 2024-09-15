package com.rnagaraju.goflights.dto.user;

import java.util.List;

public class RoundTripFlightsDTO {

    private List<UserFlightDTO> outgoingFlights;
    private List<UserFlightDTO> returnFlights;

    public RoundTripFlightsDTO() {
    }

    public RoundTripFlightsDTO(List<UserFlightDTO> outgoingFlights, List<UserFlightDTO> returnFlights) {
        this.outgoingFlights = outgoingFlights;
        this.returnFlights = returnFlights;
    }

    public List<UserFlightDTO> getOutgoingFlights() {
        return outgoingFlights;
    }

    public void setOutgoingFlights(List<UserFlightDTO> outgoingFlights) {
        this.outgoingFlights = outgoingFlights;
    }

    public List<UserFlightDTO> getReturnFlights() {
        return returnFlights;
    }

    public void setReturnFlights(List<UserFlightDTO> returnFlights) {
        this.returnFlights = returnFlights;
    }
}
