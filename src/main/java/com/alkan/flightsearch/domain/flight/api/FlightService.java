package com.alkan.flightsearch.domain.flight.api;

import com.alkan.flightsearch.domain.flight.impl.Flight;

import java.util.List;

public interface FlightService {
    FlightDto create(CreateFlightRequest request);

    void delete(String id);

    FlightDto update(UpdateFlightRequest request);

    FlightDto findById(String id);

    List<FlightDto> findAll();

}
