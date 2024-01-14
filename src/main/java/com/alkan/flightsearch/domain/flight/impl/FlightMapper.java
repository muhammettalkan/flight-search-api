package com.alkan.flightsearch.domain.flight.impl;

import com.alkan.flightsearch.domain.flight.api.FlightDto;

public class FlightMapper {
    public static FlightDto toDto(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId());
        flightDto.setCreated(flight.getCreated());
        flightDto.setModified(flight.getModified());
        flightDto.setDepartureAirportIATA(flight.getDepartureAirportIATA());
        flightDto.setArrivalAirportIATA(flight.getArrivalAirportIATA());
        flightDto.setDepartureTime(flight.getDepartureTime());
        flightDto.setArrivalTime(flight.getArrivalTime());
        flightDto.setPrice(flight.getPrice());
        return flightDto;
    }

    public static Flight toEntity(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setDepartureAirportIATA(flightDto.getDepartureAirportIATA());
        flight.setArrivalAirportIATA(flightDto.getArrivalAirportIATA());
        flight.setDepartureTime(flightDto.getDepartureTime());
        flight.setArrivalTime(flightDto.getArrivalTime());
        flight.setPrice(flightDto.getPrice());
        return flight;
    }
}
