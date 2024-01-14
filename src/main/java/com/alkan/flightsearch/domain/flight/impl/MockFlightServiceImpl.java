package com.alkan.flightsearch.domain.flight.impl;

import com.alkan.flightsearch.domain.flight.api.MockFlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MockFlightServiceImpl implements MockFlightService {
    @Override
    public List<Flight> getFlights(){
        return List.of(
                new Flight( "IST", "SAW", LocalDateTime.parse("2024-01-14T10:00:00"), LocalDateTime.parse("2024-01-14T12:00:00"), 100.0),
                new Flight( "IST", "LON", LocalDateTime.parse("2024-01-14T14:00:00"), LocalDateTime.parse("2024-01-14T18:00:00"), 250.0),
                new Flight( "IST", "NYC", LocalDateTime.parse("2024-01-14T20:00:00"), LocalDateTime.parse("2024-01-15T02:00:00"), 500.0)
        );
    }

}
