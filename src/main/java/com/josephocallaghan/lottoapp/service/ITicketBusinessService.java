package com.josephocallaghan.lottoapp.service;

import java.util.List;

import com.josephocallaghan.lottoapp.dto.TicketDto;

public interface ITicketBusinessService {

	TicketDto createTicket(final Integer numOfLines);
	
	List<TicketDto> getAllTickets();

	TicketDto getTicketByTicketNo(final Integer ticketNo);
	
	TicketDto ammedTicket(final Integer ticketNo, final Integer numOfLines);

	TicketDto calculateTicketStatus(final Integer ticketNo);
	
}
