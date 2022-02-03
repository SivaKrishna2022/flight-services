package com.flight.ticket.service;

import java.util.List;

import com.flight.ticket.model.Ticket;

public interface TicketService {

	// Save operation
	Ticket saveTicket(Ticket ticket);

	// Read operation
	List<Ticket> fetchTicketList();

	// Update operation
	Ticket updateTicket(Ticket Ticket, Long TicketId);

	// Delete operation
	void deleteTicketById(Long TicketId);

}
