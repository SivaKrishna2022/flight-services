package com.flight.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.airport.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

}
