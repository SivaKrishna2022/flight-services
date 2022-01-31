package com.flight.schedule.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "schedule")
@JsonInclude(value = Include.NON_NULL)
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Long airportId;
	@NotNull
	private Long flightId;
	@NotBlank
	@Size(max = 30)
	private String arraivalTime;
	@NotBlank
	@Size(max = 8)
	private String departureTime;

	public Schedule(Long id, @NotNull Long airportId, @NotNull Long flightId,
			@NotBlank @Size(max = 30) String arraivalTime, @NotBlank @Size(max = 8) String departureTime) {
		super();
		this.id = id;
		this.airportId = airportId;
		this.flightId = flightId;
		this.arraivalTime = arraivalTime;
		this.departureTime = departureTime;
	}

	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the airportId
	 */
	public Long getAirportId() {
		return airportId;
	}

	/**
	 * @param airportId the airportId to set
	 */
	public void setAirportId(Long airportId) {
		this.airportId = airportId;
	}

	/**
	 * @return the flightId
	 */
	public Long getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	/**
	 * @return the arraivalTime
	 */
	public String getArraivalTime() {
		return arraivalTime;
	}

	/**
	 * @param arraivalTime the arraivalTime to set
	 */
	public void setArraivalTime(String arraivalTime) {
		this.arraivalTime = arraivalTime;
	}

	/**
	 * @return the departureTime
	 */
	public String getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", airportId=" + airportId + ", flightId=" + flightId + ", arraivalTime="
				+ arraivalTime + ", departureTime=" + departureTime + "]";
	}

}
