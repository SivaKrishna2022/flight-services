package com.flight.ticket.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.ticket.model.Ticket;
import com.flight.ticket.repository.TicketRepository;
import com.flight.ticket.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> fetchTicketList() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket updateTicket(Ticket ticket, Long ticketId) {

		Ticket ticketDB = ticketRepository.findById(ticketId).get();

		if (Objects.nonNull(ticket.getStatus()) && !"".equalsIgnoreCase(ticket.getStatus())) {
			ticketDB.setStatus(ticket.getStatus());
			ticketDB.setUpdatedDate(LocalDate.now().toString());
		}

		return ticketRepository.save(ticketDB);
	}

	@Override
	public void deleteTicketById(Long ticketId) {
		ticketRepository.deleteById(ticketId);

	}
}
