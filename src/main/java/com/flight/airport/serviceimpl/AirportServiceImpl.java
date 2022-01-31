package com.flight.airport.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.airport.model.Airport;
import com.flight.airport.repository.AirportRepository;
import com.flight.airport.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {
	@Autowired
	private AirportRepository airportRepository;

	@Override
	public Airport saveAirport(Airport airport) {
		return airportRepository.save(airport);
	}

	@Override
	public List<Airport> fetchAirportList() {
		return airportRepository.findAll();
	}

	@Override
	public Airport updateAirport(Airport airport, Long airportId) {

		Airport airportDB = airportRepository.findById(airportId).get();

		if (Objects.nonNull(airport.getName()) && !"".equalsIgnoreCase(airport.getName())) {
			airportDB.setName(airport.getName());
		}

		if (Objects.nonNull(airport.getCity()) && !"".equalsIgnoreCase(airport.getCity())) {
			airportDB.setCity(airport.getCity());
		}

		if (Objects.nonNull(airport.getState()) && !"".equalsIgnoreCase(airport.getState())) {
			airportDB.setState(airport.getState());
		}

		if (Objects.nonNull(airport.getPinCode()) && !"".equalsIgnoreCase(airport.getPinCode())) {
			airportDB.setPinCode(airport.getPinCode());
		}

		return airportRepository.save(airportDB);
	}

	@Override
	public void deleteAirportById(Long airportId) {
		airportRepository.deleteById(airportId);

	}
}
