package com.josephocallaghan.lottoapp.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.josephocallaghan.lottoapp.domain.TicketLineEntity;
import com.josephocallaghan.lottoapp.service.impl.TicketBusinessService;

public class TicketStatusControllerTest {
	
	TicketBusinessService ticketBusinessService = new TicketBusinessService();
	
	@Test
	public void ticketStatusTen() {
		
		// Ticket outcome should be 10
		TicketLineEntity line = new TicketLineEntity();
		line.setNum1(1);
		line.setNum2(1);
		line.setNum3(0);
		int i = ticketBusinessService.ticketStatusHelper(line);
		assertEquals(10, i, "If the sum of all values is 2, the line is 10");
	}
	
	@Test
	public void ticketStatusFive() {
		
		// Ticket outcome should be 5
		TicketLineEntity line = new TicketLineEntity();
		line.setNum1(2);
		line.setNum2(2);
		line.setNum3(2);
		int i = ticketBusinessService.ticketStatusHelper(line);
		assertEquals(5, i, "If all values are the same, the line is 5");
	}
	
	@Test
	public void ticketStatusTwo() {
		
		// Ticket outcome should be 1
		TicketLineEntity line = new TicketLineEntity();
		line.setNum1(0);
		line.setNum2(1);
		line.setNum3(2);
		int i = ticketBusinessService.ticketStatusHelper(line);
		assertEquals(1, i, "If all values are not the same, the line is 1");
	}
	
	@Test
	public void ticketStatusZero() {
		
		// Ticket outcome should be 0
		TicketLineEntity line = new TicketLineEntity();
		line.setNum1(0);
		line.setNum2(0);
		line.setNum3(1);
		int i = ticketBusinessService.ticketStatusHelper(line);
		assertEquals(0, i, "If none of the other citeria is met, the line is 0");
	}

}
