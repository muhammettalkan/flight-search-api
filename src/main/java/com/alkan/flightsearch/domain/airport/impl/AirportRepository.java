package com.alkan.flightsearch.domain.airport.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, String> {

    Optional<Airport> findById(String id);
    Optional<Airport> findByIATA(String IATA);
}
