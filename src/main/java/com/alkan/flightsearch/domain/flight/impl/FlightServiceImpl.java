package com.alkan.flightsearch.domain.flight.impl;

import com.alkan.flightsearch.domain.airport.api.AirportService;
import com.alkan.flightsearch.domain.flight.api.CreateFlightRequest;
import com.alkan.flightsearch.domain.flight.api.FlightDto;
import com.alkan.flightsearch.domain.flight.api.FlightService;
import com.alkan.flightsearch.domain.flight.api.UpdateFlightRequest;
import com.alkan.flightsearch.library.exception.custom.ResourceNotFoundException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final MockFlightServiceImpl mockFlightService;
    private final AirportService airportService;

    public FlightServiceImpl(FlightRepository flightRepository, MockFlightServiceImpl mockFlightService, AirportService airportService) {
        this.flightRepository = flightRepository;
        this.mockFlightService = mockFlightService;
        this.airportService = airportService;
    }
    @Scheduled(cron = "0 0 0 * * *")
    private void scheduleFlights() {
        flightRepository.saveAll(mockFlightService.getFlights());
    }

    @Override
    public FlightDto create(CreateFlightRequest request) {
        Flight flight = new Flight();
        flight.setDepartureAirportIATA(request.departureAirportIATA());
        flight.setArrivalAirportIATA(request.arrivalAirportIATA());
        if (airportService.findByIATA(request.departureAirportIATA()) == null || airportService.findByIATA(request.arrivalAirportIATA()) == null) {
            throw new ResourceNotFoundException("Airport", "IATA", "" + request.departureAirportIATA());
        }
        flight.setDepartureTime(request.departureTime());
        flight.setArrivalTime(request.arrivalTime());
        flight.setPrice(request.price());
        flightRepository.save(flight);
        return FlightMapper.toDto(flight);
    }
    @Override
    public void delete(String id) {
        flightRepository.deleteById(id);
    }
    @Override
    public FlightDto update(UpdateFlightRequest request) {
        Flight flight = flightRepository.findById(request.id())
                .orElseThrow(() -> new ResourceNotFoundException("Flight", "id", "" + request.id()));
        flight.setDepartureTime(request.departureTime());
        flight.setArrivalTime(request.arrivalTime());
        flight.setPrice(request.price());
        flightRepository.save(flight);
        return FlightMapper.toDto(flight);
    }
    @Override
    public FlightDto findById(String id) {
        return flightRepository.findById(id)
                .map(FlightMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Flight", "id", "" + id));
    }
    @Override
    public List<FlightDto> findAll() {
        return flightRepository.findAll()
                .stream()
                .map(FlightMapper::toDto)
                .collect(Collectors.toList());
    }




}
