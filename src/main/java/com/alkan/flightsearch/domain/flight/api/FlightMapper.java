package com.alkan.flightsearch.domain.flight.api;

import com.alkan.flightsearch.domain.flight.web.FlightRequest;
import com.alkan.flightsearch.domain.flight.web.FlightResponse;

public class FlightMapper {
    public static FlightDto toDTO(FlightRequest flightRequest) {
        FlightDto flightDto = new FlightDto();
        flightDto.setDepartureAirportIATA(flightRequest.getDepartureAirportIATA());
        flightDto.setArrivalAirportIATA(flightRequest.getArrivalAirportIATA());
        flightDto.setDepartureTime(flightRequest.getDepartureTime());
        flightDto.setArrivalTime(flightRequest.getArrivalTime());
        flightDto.setPrice(flightRequest.getPrice());
        return flightDto;

    }

    public static FlightResponse toResponse(FlightDto flightDto) {
        FlightResponse flightResponse = new FlightResponse();
        flightResponse.setId(flightDto.getId());
        flightResponse.setCreated(flightDto.getCreated());
        flightResponse.setModified(flightDto.getModified());
        flightResponse.setDepartureAirportIATA(flightDto.getDepartureAirportIATA());
        flightResponse.setArrivalAirportIATA(flightDto.getArrivalAirportIATA());
        flightResponse.setDepartureTime(flightDto.getDepartureTime());
        flightResponse.setArrivalTime(flightDto.getArrivalTime());
        flightResponse.setPrice(flightDto.getPrice());
        return flightResponse;
    }
}
