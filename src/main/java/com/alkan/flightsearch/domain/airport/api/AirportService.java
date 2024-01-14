package com.alkan.flightsearch.domain.airport.api;

import java.util.List;

public interface AirportService {
    AirportDto create(AirportDto dto);

    List<AirportDto> findAll();

    AirportDto findByIATA(String IATA);

    AirportDto findById(String IATA);

    AirportDto update(String id, AirportDto dto);

    void delete(String IATA);
}
