package com.flight.services.serviceimpl;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.flight.services.model.Flight;
import com.flight.services.repository.FlightRepository;

class FlightServiceImplTest {
	@InjectMocks
	private FlightServiceImpl flightServiceImpl = new FlightServiceImpl();
	@Mock
	private FlightRepository flightRepository = Mockito.mock(FlightRepository.class);

	@BeforeEach
	public void setUp() {
		ReflectionTestUtils.setField(flightServiceImpl, "flightRepository", flightRepository);
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveFlight() {
		ReflectionTestUtils.setField(flightServiceImpl, "flightRepository", flightRepository);
		Mockito.when(flightRepository.save(Mockito.any())).thenReturn(new Flight());
		flightServiceImpl.saveFlight(new Flight());
	}

	@Test
	void testFetchFlightList() {
		Mockito.when(flightRepository.findAll()).thenReturn(Arrays.asList(new Flight()));
		flightServiceImpl.fetchFlightList();
	}

	@Test
	void testUpdateFlight() {
		Mockito.when(flightRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Flight()));
		Mockito.when(flightRepository.save(Mockito.any())).thenReturn(new Flight());
		flightServiceImpl.updateFlight(new Flight(), 1L);
	}

	@Test
	void testDeleteFlightById() {
		flightServiceImpl.deleteFlightById(1L);
	}

}
