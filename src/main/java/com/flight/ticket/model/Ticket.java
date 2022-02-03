package com.flight.ticket.model;

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
@Table(name = "ticket")
@JsonInclude(value = Include.NON_NULL)
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 50)
	private String username;

	@NotNull
	private Long flightId;
	@NotNull
	private Long airportId;
	@NotNull
	private Long scheduleId;

	@NotBlank
	@Size(max = 50)
	private String status;

	@NotBlank
	@Size(max = 50)
	private String createdDate;


	private String updatedDate;

	public Ticket(Long id, @NotBlank @Size(max = 50) String username, @NotNull Long flightId, @NotNull Long airportId,
			@NotNull Long scheduleId, @NotBlank @Size(max = 50) String status,
			@NotBlank @Size(max = 50) String createdDdate, @NotBlank @Size(max = 50) String updatedDate) {
		super();
		this.id = id;
		this.username = username;
		this.flightId = flightId;
		this.airportId = airportId;
		this.scheduleId = scheduleId;
		this.status = status;
		this.createdDate = createdDdate;
		this.updatedDate = updatedDate;
	}

	public Ticket() {
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the scheduleId
	 */
	public Long getScheduleId() {
		return scheduleId;
	}

	/**
	 * @param scheduleId the scheduleId to set
	 */
	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the createdDdate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDdate the createdDdate to set
	 */
	public void setCreatedDate(String createdDdate) {
		this.createdDate = createdDdate;
	}

	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", username=" + username + ", flightId=" + flightId + ", airportId=" + airportId
				+ ", scheduleId=" + scheduleId + ", status=" + status + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}

}
