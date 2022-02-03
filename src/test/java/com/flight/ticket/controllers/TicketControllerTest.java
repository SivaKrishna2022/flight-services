package com.flight.ticket.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flight.login.models.User;
import com.flight.login.payload.request.LoginRequest;
import com.flight.login.repository.RoleRepository;
import com.flight.login.repository.UserRepository;
import com.flight.login.security.jwt.AuthEntryPointJwt;
import com.flight.login.security.jwt.JwtUtils;
import com.flight.login.security.services.UserDetailsServiceImpl;
import com.flight.ticket.model.Ticket;
import com.flight.ticket.serviceimpl.TicketServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(TicketController.class)
class TicketControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private TicketServiceImpl ticketServiceImpl;
	@MockBean
	private UserDetailsServiceImpl detailsServiceImpl;

	@MockBean
	AuthenticationManager authenticationManager;

	@MockBean
	UserRepository userRepository;

	@MockBean
	RoleRepository roleRepository;

	@MockBean
	PasswordEncoder encoder;

	@MockBean
	JwtUtils jwtUtils;
	@MockBean
	AuthEntryPointJwt authEntryPointJwt;

	private static ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	public void setup() {
		User user = new User("ramu", "ramu@gmail.com", "123456");
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername(user.getUsername());
		loginRequest.setPassword(user.getPassword());
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null);
		Mockito.when(authenticationManager.authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class)))
				.thenReturn(authentication);

		Mockito.when(jwtUtils.validateJwtToken(Mockito.anyString())).thenReturn(true);
		Mockito.when(jwtUtils.getUserNameFromJwtToken(Mockito.anyString())).thenReturn(user.getUsername());
		Mockito.when(jwtUtils.getJwtFromCookies(Mockito.any(HttpServletRequest.class))).thenReturn("test");
		Mockito.when(detailsServiceImpl.loadUserByUsername(user.getUsername()))
				.thenReturn(Mockito.mock(UserDetails.class));
	}

	@Test
	void testSaveTicket() throws Exception {
		Ticket ticket = new Ticket(1L, "ramu", 1L, 1L, 1L, "CREATED", "2022-02-02'T'22:00:00", null);
		Mockito.when(ticketServiceImpl.saveTicket(Mockito.any())).thenReturn(ticket);
		String json = mapper.writeValueAsString(ticket);
		mockMvc.perform(post("/api/ticket").contentType(MediaType.APPLICATION_JSON).content(json)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void testFetchTicketList() throws Exception {
		List<Ticket> tickets = new ArrayList<Ticket>();
		Ticket ticket = new Ticket(1L, "ramu", 1L, 1L, 1L, "CREATED", "2022-02-02'T'22:00:00", null);
		tickets.add(ticket);
		Mockito.when(ticketServiceImpl.fetchTicketList()).thenReturn(tickets);
		mockMvc.perform(get("/api/ticket")).andExpect(status().isOk());
	}

	@Test
	void testUpdateTicket() throws Exception {
		Ticket ticket = new Ticket();
		ticket.setUpdatedDate("2022-02-02'T'22:00:00");
		Mockito.when(ticketServiceImpl.updateTicket(Mockito.any(), Mockito.anyLong())).thenReturn(ticket);
		String json = mapper.writeValueAsString(ticket);
		mockMvc.perform(put("/api/ticket/1").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	void testDeleteTicketById() throws Exception {
		mockMvc.perform(delete("/api/ticket/1")).andExpect(status().isOk());
	}

}
