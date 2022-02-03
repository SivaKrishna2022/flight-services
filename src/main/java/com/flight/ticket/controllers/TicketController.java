package com.flight.ticket.controllers;

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

import com.flight.ticket.model.Ticket;
import com.flight.ticket.serviceimpl.TicketServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TicketController {// Annotation
	@Autowired
	private TicketServiceImpl ticketServiceImpl;

	// Save operation
	@PostMapping("/ticket")
	public Ticket saveTicket(@Valid @RequestBody Ticket ticket) {
		return ticketServiceImpl.saveTicket(ticket);
	}

	// Read operation
	@GetMapping("/ticket")
	public List<Ticket> fetchTicketList() {
		return ticketServiceImpl.fetchTicketList();
	}

	// Update operation
	@PutMapping("/ticket/{id}")
	public Ticket updateTicket(@RequestBody Ticket ticket, @PathVariable("id") Long ticketId) {
		return ticketServiceImpl.updateTicket(ticket, ticketId);
	}

	// Delete operation
	@DeleteMapping("/ticket/{id}")
	public String deleteTicketById(@PathVariable("id") Long ticketId) {
		ticketServiceImpl.deleteTicketById(ticketId);
		return "Deleted Successfully";
	}
}
