package com.flight.ticket.serviceimpl;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.flight.ticket.model.Ticket;
import com.flight.ticket.repository.TicketRepository;

class TicketServiceImplTest {
	@InjectMocks
	private TicketServiceImpl ticketServiceImpl = new TicketServiceImpl();
	@Mock
	private TicketRepository ticketRepository = Mockito.mock(TicketRepository.class);

	@BeforeEach
	public void setUp() {
		ReflectionTestUtils.setField(ticketServiceImpl, "ticketRepository", ticketRepository);
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSaveTicket() {
		ReflectionTestUtils.setField(ticketServiceImpl, "ticketRepository", ticketRepository);
		Mockito.when(ticketRepository.save(Mockito.any())).thenReturn(new Ticket());
		ticketServiceImpl.saveTicket(new Ticket());
	}

	@Test
	void testFetchTicketList() {
		Mockito.when(ticketRepository.findAll()).thenReturn(Arrays.asList(new Ticket()));
		ticketServiceImpl.fetchTicketList();
	}

	@Test
	void testUpdateTicket() {
		Mockito.when(ticketRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Ticket()));
		Mockito.when(ticketRepository.save(Mockito.any())).thenReturn(new Ticket());
		ticketServiceImpl.updateTicket(new Ticket(), 1L);
	}

	@Test
	void testDeleteTicketById() {
		ticketServiceImpl.deleteTicketById(1L);
	}

}
