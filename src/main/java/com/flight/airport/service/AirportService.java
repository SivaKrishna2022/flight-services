package com.flight.airport.service;

import java.util.List;

import com.flight.airport.model.Airport;

public interface AirportService {

	// Save operation
	Airport saveAirport(Airport airport);

	// Read operation
	List<Airport> fetchAirportList();

	// Update operation
	Airport updateAirport(Airport Airport, Long AirportId);

	// Delete operation
	void deleteAirportById(Long AirportId);

}
