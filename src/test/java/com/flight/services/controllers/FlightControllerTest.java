package com.flight.services.controllers;

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
import com.flight.services.model.Flight;
import com.flight.services.serviceimpl.FlightServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
class FlightControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private FlightServiceImpl flightServiceImpl;
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
	void testSaveFlight() throws Exception {
		Flight flight = new Flight(1L, "air lines", 25, 0);
		Mockito.when(flightServiceImpl.saveFlight(Mockito.any())).thenReturn(flight);
		String json = mapper.writeValueAsString(flight);
		mockMvc.perform(post("/api/flight").contentType(MediaType.APPLICATION_JSON).content(json)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void testFetchFlightList() throws Exception {
		List<Flight> flights = new ArrayList<Flight>();
		Flight flight = new Flight(1L, "air lines", 25, 0);
		flights.add(flight);
		Mockito.when(flightServiceImpl.fetchFlightList()).thenReturn(flights);
		mockMvc.perform(get("/api/flight")).andExpect(status().isOk());
	}

	@Test
	void testUpdateFlight() throws Exception {
		Flight flight = new Flight();
		flight.setBookedSeats(1);
		Mockito.when(flightServiceImpl.updateFlight(Mockito.any(), Mockito.anyLong())).thenReturn(flight);
		String json = mapper.writeValueAsString(flight);
		mockMvc.perform(put("/api/flight/1").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
				.content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	@Test
	void testDeleteFlightById() throws Exception {
		mockMvc.perform(delete("/api/flight/1")).andExpect(status().isOk());
	}

}
