package com.flight.airport.serviceimpl;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.flight.airport.model.Airport;
import com.flight.airport.repository.AirportRepository;

class AirportServiceImplTest {
	@InjectMocks
	private AirportServiceImpl airportServiceImpl = new AirportServiceImpl();
	@Mock
	private AirportRepository airportRepository = Mockito.mock(AirportRepository.class);

	@BeforeEach
	public void setUp() {
		ReflectionTestUtils.setField(airportServiceImpl, "airportRepository", airportRepository);
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveAirport() {
		ReflectionTestUtils.setField(airportServiceImpl, "airportRepository", airportRepository);
		Mockito.when(airportRepository.save(Mockito.any())).thenReturn(new Airport());
		airportServiceImpl.saveAirport(new Airport());
	}

	@Test
	void testFetchAirportList() {
		Mockito.when(airportRepository.findAll()).thenReturn(Arrays.asList(new Airport()));
		airportServiceImpl.fetchAirportList();
	}

	@Test
	void testUpdateAirport() {
		Mockito.when(airportRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Airport()));
		Mockito.when(airportRepository.save(Mockito.any())).thenReturn(new Airport());
		airportServiceImpl.updateAirport(new Airport(), 1L);
	}

	@Test
	void testDeleteAirportById() {
		airportServiceImpl.deleteAirportById(1L);
	}

}
