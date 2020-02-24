package com.josephocallaghan.lottoapp.dto;

import java.util.List;
import java.util.Objects;

public class TicketDto {

	private Integer ticketNumber;
	private List<TicketLineDto> ticketLines;
	private Boolean checked = Boolean.FALSE;
	
	public TicketDto() {}
	
	public TicketDto(List<TicketLineDto> ticketLines) {
		ticketNumber = ticketLines.get(1).getTicketNumber();
		this.ticketLines = ticketLines;
		this.checked = (Objects.nonNull(ticketLines.get(1).getTicketStatus()) ? Boolean.TRUE : Boolean.FALSE);
	}
	
	public Integer getTicketNumber() {
		return ticketNumber;
	}
	
	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	public List<TicketLineDto> getTicketLines() {
		return ticketLines;
	}
	
	public void setTicketLines(List<TicketLineDto> ticketLines) {
		this.ticketLines = ticketLines;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	
}
