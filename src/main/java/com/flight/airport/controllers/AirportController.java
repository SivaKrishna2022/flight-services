package com.flight.airport.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.airport.model.Airport;
import com.flight.airport.serviceimpl.AirportServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AirportController {// Annotation
	@Autowired
	private AirportServiceImpl airportServiceImpl;

	// Save operation
	@PostMapping("/airport")
	public Airport saveAirport(@Valid @RequestBody Airport airport) {
		return airportServiceImpl.saveAirport(airport);
	}

	// Read operation
	@GetMapping("/airport")
	public List<Airport> fetchAirportList() {
		return airportServiceImpl.fetchAirportList();
	}

	// Update operation
	@PutMapping("/airport/{id}")
	public Airport updateAirport(@RequestBody Airport airport, @PathVariable("id") Long airportId) {
		return airportServiceImpl.updateAirport(airport, airportId);
	}

	// Delete operation
	@DeleteMapping("/airport/{id}")
	public String deleteAirportById(@PathVariable("id") Long airportId) {
		airportServiceImpl.deleteAirportById(airportId);
		return "Deleted Successfully";
	}
}
