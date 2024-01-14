package com.alkan.flightsearch.domain.airport.api;

import com.alkan.flightsearch.domain.airport.web.AirportRequest;
import com.alkan.flightsearch.domain.airport.web.AirportResponse;

public class AirportMapper {
    public static AirportDto toDto(AirportRequest request) {
        AirportDto airportDto = new AirportDto();
        airportDto.setIATA(request.IATA());
        airportDto.setCity(request.city());
        return airportDto;
    }

    public static AirportResponse toResponse(AirportDto airportDto) {
        AirportResponse airportResponse = new AirportResponse();
        airportResponse.setId(airportDto.getId());
        airportResponse.setCreated(airportDto.getCreated());
        airportResponse.setModified(airportDto.getModified());
        airportResponse.setIATA(airportDto.getIATA());
        airportResponse.setCity(airportDto.getCity());

        return airportResponse;

    }
}
