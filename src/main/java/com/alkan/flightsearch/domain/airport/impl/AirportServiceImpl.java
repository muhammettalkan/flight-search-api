package com.alkan.flightsearch.domain.airport.impl;

import com.alkan.flightsearch.domain.airport.api.AirportDto;
import com.alkan.flightsearch.domain.airport.api.AirportService;
import com.alkan.flightsearch.library.exception.custom.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public AirportDto create(AirportDto dto) {
        Airport airport = AirportMapper.toEntity(dto);
        return AirportMapper.toDto(airportRepository.save(airport));
    }

    @Override
    public List<AirportDto> findAll() {
        return airportRepository.findAll()
                .stream()
                .map(AirportMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AirportDto findByIATA(String IATA) {
        return airportRepository.findByIATA(IATA)
                .map(AirportMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Airport", "IATA", IATA));
    }

    @Override
    public AirportDto findById(String id) {
        return airportRepository.findById(id)
                .map(AirportMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Airport", "id", id));
    }

    @Override
    public AirportDto update(String id, AirportDto dto) {
        AirportDto temp = findById(id);
        temp.setIATA(dto.getIATA());
        temp.setCity(dto.getCity());
        return AirportMapper.toDto(setAirport(temp));

    }

    @Override
    public void delete(String id) {
        Airport airport = findEntityById(id);
        airportRepository.delete(airport);
    }

    private Airport findEntityById(String id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Airport", "id", id));
    }

    private Airport setAirport(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setCity(airportDto.getCity());
        airport.setIATA(airportDto.getIATA());
        return airport;
    }


}
