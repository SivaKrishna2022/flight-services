package com.flight.services.model;

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
@Table(name = "flight")
@JsonInclude(value = Include.NON_NULL)
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String name;

	@NotNull
	private Integer availableSeats;

	private Integer bookedSeats;

	public Flight(Long id, @NotBlank @Size(max = 20) String name, @NotBlank Integer availableSeats,
			Integer bookedSeats) {
		super();
		this.id = id;
		this.name = name;
		this.availableSeats = availableSeats;
		this.bookedSeats = bookedSeats;
	}

	public Flight() {
		super();
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the availableSeats
	 */
	public Integer getAvailableSeats() {
		return availableSeats;
	}

	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	/**
	 * @return the bookedSeats
	 */
	public Integer getBookedSeats() {
		return bookedSeats;
	}

	/**
	 * @param bookedSeats the bookedSeats to set
	 */
	public void setBookedSeats(Integer bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", name=" + name + ", availableSeats=" + availableSeats + ", bookedSeats="
				+ bookedSeats + "]";
	}

}
