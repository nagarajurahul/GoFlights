package com.rnagaraju.goflights.externalClient.flight;

import com.rnagaraju.goflights.externalClient.flight.model.RequestFlightDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightService {

    @Autowired
    RestTemplate restTemplate;

    public RequestFlightDTO requestFlightInfo(Long id) {
        // Env variable or configuration for urls
        String flightUrl="http://user/flights/";
        flightUrl+=id;
        RequestFlightDTO flight=restTemplate.getForObject(flightUrl, RequestFlightDTO.class);
        return flight;
    }
}
