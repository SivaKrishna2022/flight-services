package com.flight.services.service;

import java.util.List;

import com.flight.services.model.Flight;

public interface FlightService {

	// Save operation
	Flight saveFlight(Flight flight);

	// Read operation
	List<Flight> fetchFlightList();

	// Update operation
	Flight updateFlight(Flight flight, Long flightId);

	// Delete operation
	void deleteFlightById(Long flightId);

}
