package com.alkan.flightsearch.domain.flight.web;

import com.alkan.flightsearch.domain.flight.api.CreateFlightRequest;
import com.alkan.flightsearch.domain.flight.api.FlightMapper;
import com.alkan.flightsearch.domain.flight.api.FlightService;
import com.alkan.flightsearch.domain.flight.api.UpdateFlightRequest;
import com.alkan.flightsearch.library.rest.BaseController;
import com.alkan.flightsearch.library.rest.DataResponse;
import com.alkan.flightsearch.library.rest.MetaResponse;
import com.alkan.flightsearch.library.rest.Response;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/flights")
public class FlightController extends BaseController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/find")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<FlightResponse> getById(@RequestParam String id) {
        return respond(FlightMapper.toResponse(flightService.findById(id)));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<DataResponse<FlightResponse>> findAll() {
        return respond(flightService.findAll().stream().map(FlightMapper::toResponse).collect(Collectors.toList()));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<FlightResponse> update(@RequestBody UpdateFlightRequest request) {
        return respond(FlightMapper.toResponse(flightService.update(request)));
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<Void> delete(@RequestParam String id) {
        flightService.delete(id);
        return new Response<>(MetaResponse.success());

    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response<FlightResponse> create(@RequestBody CreateFlightRequest request) {
        return respond(FlightMapper.toResponse(flightService.create(request)));
    }

}
