package com.josephocallaghan.lottoapp.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josephocallaghan.lottoapp.config.AjaxResponse;
import com.josephocallaghan.lottoapp.dto.TicketDto;

@RequestMapping("/ticket")
@RestController
public class TicketRestController extends BaseRestController {

	@PostMapping("/")
	public AjaxResponse createTicket(@RequestParam("numOfLines") final Integer numOfLines) {
		
		// Build Ajax Response Object for Front End
		AjaxResponse response = new AjaxResponse();
			
		// Create requested number of ticket lines
		TicketDto ticket = ticketBusinessService.createTicket(numOfLines);
		
		response.getData().put("ticket", ticket);
		response.setSuccess(Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/")
	public AjaxResponse getAllTickets() {
		
		// Build Ajax Response Object for Front End
		AjaxResponse response = new AjaxResponse();
			
		// Get all tickets to return
		List<TicketDto> ticketList = ticketBusinessService.getAllTickets();
		
		response.getData().put("ticketList", ticketList);
		response.setSuccess(Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/{ticketNo}")
	public AjaxResponse getTicketByTicketNo(@PathVariable("ticketNo") final Integer ticketNo) {
		
		// Build Ajax Response Object for Front End
		AjaxResponse response = new AjaxResponse();
			
		// Get ticket by id
		TicketDto ticket = ticketBusinessService.getTicketByTicketNo(ticketNo);
		
		response.getData().put("ticket", ticket);
		response.setSuccess(Boolean.TRUE);
		return response;
	}
	
	@PutMapping("/{id}")
	public AjaxResponse ammendTicket(@PathVariable("id") 			 final Integer ticketNo
											 , @RequestParam("numOfLines") final Integer numOfLines) {
		
		// Build Ajax Response Object for Front End
		AjaxResponse response = new AjaxResponse();
		
		TicketDto ticket = ticketBusinessService.getTicketByTicketNo(ticketNo);
		
		// Check if ticket status has not been checked previously
		if (Boolean.FALSE.equals(ticket.getChecked())) {
			ticket = ticketBusinessService.ammedTicket(ticketNo, numOfLines);
			
		} else {
			
			response.getData().put("error", "This ticket has been checked already, it can no longer be ammeded!");
			response.setSuccess(Boolean.FALSE);
			return response;
		}
		
		response.getData().put("ticket", ticket);
		response.setSuccess(Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/status/{id}")
	public AjaxResponse getTicketStatusById(@PathVariable("id") final Integer ticketNo) {
		
		// Build Ajax Response Object for Front End
		AjaxResponse response = new AjaxResponse();
			
		// Get Status by ID
		TicketDto ticket;
		
		try {
			
			ticket = ticketBusinessService.calculateTicketStatus(ticketNo);
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			response.getData().put("error", e.getMessage());
			response.setSuccess(Boolean.FALSE);
			return response;
		}
		
		response.getData().put("ticket", ticket);
		response.setSuccess(Boolean.TRUE);
		return response;
	}
	
}
