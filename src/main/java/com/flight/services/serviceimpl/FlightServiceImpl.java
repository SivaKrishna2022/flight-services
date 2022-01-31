package com.flight.services.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.services.model.Flight;
import com.flight.services.repository.FlightRepository;
import com.flight.services.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Flight saveFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public List<Flight> fetchFlightList() {
		return flightRepository.findAll();
	}

	@Override
	public Flight updateFlight(Flight flight, Long flightId) {

		Flight flightDb = flightRepository.findById(flightId).get();

		if (Objects.nonNull(flight.getName()) && !"".equalsIgnoreCase(flight.getName())) {
			flightDb.setName(flight.getName());
		}

		if (Objects.nonNull(flight.getAvailableSeats())) {
			flightDb.setAvailableSeats(flight.getAvailableSeats());
		}

		if (Objects.nonNull(flight.getBookedSeats())) {
			flightDb.setBookedSeats(flight.getBookedSeats());
		}
		return flightRepository.save(flightDb);
	}

	@Override
	public void deleteFlightById(Long flightId) {
		flightRepository.deleteById(flightId);

	}
}
