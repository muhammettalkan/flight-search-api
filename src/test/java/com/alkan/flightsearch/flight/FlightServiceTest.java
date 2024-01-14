package com.alkan.flightsearch.flight;

import com.alkan.flightsearch.domain.flight.impl.Flight;
import com.alkan.flightsearch.domain.flight.impl.FlightRepository;
import com.alkan.flightsearch.domain.flight.impl.FlightServiceImpl;
import com.alkan.flightsearch.domain.flight.impl.MockFlightServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FlightServiceTest {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightServiceImpl flightService;

    @Test
    public void shouldSaveFlightsToDatabase() {
        MockFlightServiceImpl flightScheduleJob = new MockFlightServiceImpl();
        List<Flight> flights = flightScheduleJob.getFlights();
        assertThat(flights.get(0).getDepartureAirportIATA()).isEqualTo("IST");
        assertThat(flights.get(0).getArrivalAirportIATA()).isEqualTo("SAW");
        assertThat(flights.get(0).getDepartureTime()).isEqualTo(LocalDateTime.parse("2024-01-14T10:00:00"));
        assertThat(flights.get(0).getArrivalTime()).isEqualTo(LocalDateTime.parse("2024-01-14T12:00:00"));
        assertThat(flights.get(0).getPrice()).isEqualTo(100.0);
    }
}
