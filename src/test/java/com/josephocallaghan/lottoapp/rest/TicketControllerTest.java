package com.josephocallaghan.lottoapp.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.josephocallaghan.lottoapp.dto.TicketDto;
import com.josephocallaghan.lottoapp.service.impl.TicketBusinessService;

public class TicketControllerTest {
	
	TicketBusinessService ticketBusinessService = new TicketBusinessService();
	
	@Test
	public void createFiveTickets() {
		
		// Create 5 ticket lines for ticket
		TicketDto ticket = ticketBusinessService.createTicket(5);
		int i = ticket.getTicketLines().size();
		assertEquals(5, i, "Number of ticket lines returned is 5");
	}

}
