package com.alkan.flightsearch.domain.airport.impl;

import com.alkan.flightsearch.domain.airport.api.AirportDto;

public class AirportMapper {
    public static AirportDto toDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setId(airport.getId());
        airportDto.setCreated(airport.getCreated());
        airportDto.setModified(airport.getModified());
        airportDto.setIATA(airport.getIATA());
        airportDto.setCity(airport.getCity());
        return airportDto;
    }

    public static Airport toEntity(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setIATA(airportDto.getIATA());
        airport.setCity(airportDto.getCity());
        return airport;
    }
}
