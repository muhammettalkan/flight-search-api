package com.alkan.flightsearch.domain.search.impl;

import com.alkan.flightsearch.domain.flight.api.FlightDto;
import com.alkan.flightsearch.domain.flight.impl.FlightMapper;
import com.alkan.flightsearch.domain.flight.impl.FlightRepository;
import com.alkan.flightsearch.domain.search.api.SearchService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SearchServiceImpl implements SearchService {

    private final FlightRepository flightRepository;

    public SearchServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    @Override
    public List<FlightDto> searchByDepartureAirportIATA(String departureAirportIATA) {
        return flightRepository.findByDepartureAirportIATA(departureAirportIATA)
                .stream()
                .map(FlightMapper::toDto)
                .collect(java.util.stream.Collectors.toList());
    }
    @Override
    public List<FlightDto> searchByArrivalAirportIATA(String arrivalAirportIATA) {
        return flightRepository.findByArrivalAirportIATA(arrivalAirportIATA)
                .stream()
                .map(FlightMapper::toDto)
                .collect(java.util.stream.Collectors.toList());
    }
    @Override
    public List<FlightDto> searchByDepartureAirportIATAAndArrivalAirportIATA(String departureAirportIATA, String arrivalAirportIATA) {
        return flightRepository.findByDepartureAirportIATAAndArrivalAirportIATA(departureAirportIATA, arrivalAirportIATA)
                .stream()
                .map(FlightMapper::toDto)
                .collect(java.util.stream.Collectors.toList());
    }
    @Override
    public List<FlightDto> search(String departureAirportIATA,
                                  String arrivalAirportIATA,
                                  LocalDateTime departureDate){
        return flightRepository.findAll()
                .stream()
                .filter(flight -> flight.getDepartureAirportIATA().equals(departureAirportIATA))
                .filter(flight -> flight.getArrivalAirportIATA().equals(arrivalAirportIATA))
                .filter(flight -> flight.getDepartureTime().isAfter(departureDate))
                .map(FlightMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<FlightDto> search(
            String departureAirportIATA,
            String arrivalAirportIATA,
            LocalDateTime departureDate,
            LocalDateTime returnDate
    ) {
        if (returnDate == null) {
            return flightRepository.findAll()
                    .stream()
                    .filter(flight -> flight.getDepartureAirportIATA().equals(departureAirportIATA))
                    .filter(flight -> flight.getArrivalAirportIATA().equals(arrivalAirportIATA))
                    .filter(flight -> flight.getDepartureTime().isAfter(departureDate))
                    .map(FlightMapper::toDto)
                    .collect(Collectors.toList());
        }

        List<FlightDto> outboundFlights = flightRepository.findAll()
                .stream()
                .filter(flight -> flight.getDepartureAirportIATA().equals(departureAirportIATA))
                .filter(flight -> flight.getArrivalAirportIATA().equals(arrivalAirportIATA))
                .filter(flight -> flight.getDepartureTime().isAfter(departureDate))
                .map(FlightMapper::toDto)
                .collect(Collectors.toList());

        List<FlightDto> inboundFlights = flightRepository.findAll()
                .stream()
                .filter(flight -> flight.getDepartureAirportIATA().equals(arrivalAirportIATA))
                .filter(flight -> flight.getArrivalAirportIATA().equals(departureAirportIATA))
                .filter(flight -> flight.getDepartureTime().isAfter(returnDate))
                .map(FlightMapper::toDto)
                .collect(Collectors.toList());
        List<FlightDto> flights = Stream.concat(outboundFlights.stream(), inboundFlights.stream())
                .collect(Collectors.toList());

        return flights;
    }



}
