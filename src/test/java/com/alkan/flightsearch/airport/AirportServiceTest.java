package com.alkan.flightsearch.airport;

import com.alkan.flightsearch.domain.airport.api.AirportDto;
import com.alkan.flightsearch.domain.airport.impl.Airport;
import com.alkan.flightsearch.domain.airport.impl.AirportRepository;
import com.alkan.flightsearch.domain.airport.impl.AirportServiceImpl;
import com.alkan.flightsearch.library.exception.custom.ResourceAlreadyExistException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AirportServiceTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportServiceImpl airportService;

    @Test
    public void create_whenAirportDoesNotExist_shouldSaveAndReturnAirportDto() {
        String iata = "IST";
        AirportDto airportDto = new AirportDto(iata, "Istanbul");
        Airport airport = new Airport(iata, "Istanbul");

        when(airportRepository.findById(iata)).thenReturn(java.util.Optional.empty());
        when(airportRepository.save(airport)).thenReturn(airport);

        AirportDto createdDto = airportService.create(airportDto);

        assertThat(createdDto.getIATA()).isEqualTo(iata);
        assertThat(createdDto.getCity()).isEqualTo("Istanbul");
    }

    @Test
    public void create_whenAirportAlreadyExists_shouldThrowAirportAlreadyExistsException() {
        String iata = "IST";
        AirportDto airportDto = new AirportDto(iata, "Istanbul");

        when(airportRepository.findById(iata)).thenReturn(java.util.Optional.of(new Airport()));
        assertThrows(ResourceAlreadyExistException.class, () -> airportService.create(airportDto));

    }

}
