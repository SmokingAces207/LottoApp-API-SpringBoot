package com.josephocallaghan.lottoapp.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.josephocallaghan.lottoapp.service.ITicketBusinessService;

public class BaseRestController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	protected ITicketBusinessService ticketBusinessService;
	
}
