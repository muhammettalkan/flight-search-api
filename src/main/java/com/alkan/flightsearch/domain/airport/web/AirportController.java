package com.alkan.flightsearch.domain.airport.web;

import com.alkan.flightsearch.domain.airport.api.AirportDto;
import com.alkan.flightsearch.domain.airport.api.AirportMapper;
import com.alkan.flightsearch.domain.airport.api.AirportService;
import com.alkan.flightsearch.library.rest.BaseController;
import com.alkan.flightsearch.library.rest.DataResponse;
import com.alkan.flightsearch.library.rest.MetaResponse;
import com.alkan.flightsearch.library.rest.Response;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/airports")
public class AirportController extends BaseController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<DataResponse<AirportResponse>> findAll() {
        return respond(airportService.findAll().stream().map(AirportMapper::toResponse).collect(Collectors.toList()));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/find")
    public Response<AirportResponse> findById(@RequestParam String IATA) {
        return respond(AirportMapper.toResponse(airportService.findById(IATA)));
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<AirportResponse> create(@RequestBody AirportDto airportDto) {
        return respond(AirportMapper.toResponse(airportService.create(airportDto)));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<AirportResponse> update(@RequestParam String id,@RequestBody AirportDto airportDto) {
        return respond(AirportMapper.toResponse(airportService.update(id,airportDto)));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<Void> delete(@RequestParam String IATA) {
        airportService.delete(IATA);
        return new Response<>(MetaResponse.success());
    }

}
