package com.alkan.flightsearch.domain.search.api;

import com.alkan.flightsearch.domain.flight.api.FlightDto;

import java.time.LocalDateTime;
import java.util.List;

public interface SearchService {
    List<FlightDto> searchByDepartureAirportIATA(String departureAirportIATA);

    List<FlightDto> searchByArrivalAirportIATA(String arrivalAirportIATA);

    List<FlightDto> searchByDepartureAirportIATAAndArrivalAirportIATA(String departureAirportIATA, String arrivalAirportIATA);

    List<FlightDto> search(String departureAirportIATA,
                           String arrivalAirportIATA,
                           LocalDateTime departureDate);

    List<FlightDto> search(
            String departureAirportIATA,
            String arrivalAirportIATA,
            LocalDateTime departureDate,
            LocalDateTime returnDate
    );

    //List<FlightDto> searchByDepartureAirportIATAAndArrivalAirportIATAAndDepartureTime(String departureAirportIATA, String arrivalAirportIATA, String departureTime);

    //List<FlightDto> findByDepartureAirportIATAAndArrivalAirportIATAAndDepartureTimeAndArrivalTime(String departureAirportIATA, String arrivalAirportIATA, String departureTime, String arrivalTime);
}
