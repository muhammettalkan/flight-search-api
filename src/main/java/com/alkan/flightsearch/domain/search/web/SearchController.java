package com.alkan.flightsearch.domain.search.web;


import com.alkan.flightsearch.domain.flight.api.FlightMapper;
import com.alkan.flightsearch.domain.flight.web.FlightResponse;
import com.alkan.flightsearch.domain.search.api.SearchService;
import com.alkan.flightsearch.library.rest.BaseController;
import com.alkan.flightsearch.library.rest.DataResponse;
import com.alkan.flightsearch.library.rest.Response;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/search")
public class SearchController extends BaseController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/by-departure-airport-iata")
    public Response<DataResponse<FlightResponse>> searchByDepartureAirportIATA(@RequestParam String departureAirportIATA) {
        return respond(searchService.searchByDepartureAirportIATA(departureAirportIATA)
                .stream()
                .map(FlightMapper::toResponse)
                .collect(java.util.stream.Collectors.toList()));
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/by-arrival-airport-iata")
    public Response<DataResponse<FlightResponse>> searchByArrivalAirportIATA(@RequestParam String arrivalAirportIATA) {
        return respond(searchService.searchByArrivalAirportIATA(arrivalAirportIATA)
                .stream()
                .map(FlightMapper::toResponse)
                .collect(java.util.stream.Collectors.toList()));
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/by-departure-airport-iata-and-arrival-airport-iata")
    public Response<DataResponse<FlightResponse>> searchByDepartureAirportIATAAndArrivalAirportIATA(@RequestParam String departureAirportIATA,
                                                                                                    @RequestParam String arrivalAirportIATA) {
        return respond(searchService.searchByDepartureAirportIATAAndArrivalAirportIATA(departureAirportIATA, arrivalAirportIATA)
                .stream()
                .map(FlightMapper::toResponse)
                .collect(java.util.stream.Collectors.toList()));
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/specify")
    public Response<DataResponse<FlightResponse>> search(@RequestParam String departureAirportIATA,
                                                         @RequestParam String arrivalAirportIATA,
                                                         @RequestParam LocalDateTime departureDate) {
        return respond(searchService.search(departureAirportIATA, arrivalAirportIATA, departureDate)
                .stream()
                .map(FlightMapper::toResponse)
                .collect(java.util.stream.Collectors.toList()));
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/specify-with-return")
    public Response<DataResponse<FlightResponse>> search(@RequestParam String departureAirportIATA,
                                                         @RequestParam String arrivalAirportIATA,
                                                         @RequestParam LocalDateTime departureDate,
                                                         @RequestParam LocalDateTime returnDate) {
        return respond(searchService.search(departureAirportIATA, arrivalAirportIATA, departureDate, returnDate)
                .stream()
                .map(FlightMapper::toResponse)
                .collect(java.util.stream.Collectors.toList()));
    }
}
