package com.josephocallaghan.lottoapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.josephocallaghan.lottoapp.repository.TicketLineRepository;
import com.josephocallaghan.lottoapp.repository.TicketRepository;

public class BaseBusinessService {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	protected TicketRepository ticketRepository;
	
	@Autowired
	protected TicketLineRepository ticketLineRepository;
	
}
