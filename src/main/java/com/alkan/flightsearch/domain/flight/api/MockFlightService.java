package com.alkan.flightsearch.domain.flight.api;

import com.alkan.flightsearch.domain.flight.impl.Flight;

import java.util.List;

public interface MockFlightService {
    List<Flight> getFlights();
}
