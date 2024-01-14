package com.alkan.flightsearch.domain.flight.api;

import java.time.LocalDateTime;

public record CreateFlightRequest(String departureAirportIATA,
                                  String arrivalAirportIATA,
                                  LocalDateTime departureTime,
                                  LocalDateTime arrivalTime,
                                  double price) {
}
