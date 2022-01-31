package com.flight.services.controllers;

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

import com.flight.services.model.Flight;
import com.flight.services.serviceimpl.FlightServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FlightController {// Annotation
	@Autowired
	private FlightServiceImpl flightServiceImpl;

	// Save operation
	@PostMapping("/flight")
	public Flight saveFlight(@Valid @RequestBody Flight flight) {
		return flightServiceImpl.saveFlight(flight);
	}

	// Read operation
	@GetMapping("/flight")
	public List<Flight> fetchFlightList() {
		return flightServiceImpl.fetchFlightList();
	}

	// Update operation
	@PutMapping("/flight/{id}")
	public Flight updateFlight(@RequestBody Flight Flight, @PathVariable("id") Long flightId) {
		return flightServiceImpl.updateFlight(Flight, flightId);
	}

	// Delete operation
	@DeleteMapping("/flight/{id}")
	public String deleteFlightById(@PathVariable("id") Long flightId) {
		flightServiceImpl.deleteFlightById(flightId);
		return "Deleted Successfully";
	}
}
