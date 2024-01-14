package com.alkan.flightsearch.domain.flight.api;

import java.time.LocalDateTime;

public record UpdateFlightRequest(String id,
                                  LocalDateTime departureTime,
                                  LocalDateTime arrivalTime,
                                  double price) {
}
