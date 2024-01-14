package com.alkan.flightsearch.domain.flight.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findByDepartureAirportIATA(String departureAirport);
    List<Flight> findByArrivalAirportIATA(String arrivalAirport);
    List<Flight> findByDepartureAirportIATAAndArrivalAirportIATA(String departureAirport, String arrivalAirport);

}
