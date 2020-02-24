package com.josephocallaghan.lottoapp.dto;

import com.josephocallaghan.lottoapp.domain.TicketLineEntity;

public class TicketLineDto {
	
	private Integer id;
	
	private Integer ticketNumber;

	private Integer num1;
	private Integer num2;
	private Integer num3;
	
	private Integer ticketStatus;
	
	public TicketLineDto() {}
	
	public TicketLineDto(TicketLineEntity entity) {
		id = entity.getId();
		ticketNumber = entity.getTicketNumber();
		num1 = entity.getNum1();
		num2 = entity.getNum2();
		num3 = entity.getNum3();
		ticketStatus = entity.getTicketStatus();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((num1 == null) ? 0 : num1.hashCode());
		result = prime * result + ((num2 == null) ? 0 : num2.hashCode());
		result = prime * result + ((num3 == null) ? 0 : num3.hashCode());
		result = prime * result + ((ticketNumber == null) ? 0 : ticketNumber.hashCode());
		result = prime * result + ((ticketStatus == null) ? 0 : ticketStatus.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketLineDto other = (TicketLineDto) obj;
		if (id != other.id)
			return false;
		if (num1 == null) {
			if (other.num1 != null)
				return false;
		} else if (!num1.equals(other.num1))
			return false;
		if (num2 == null) {
			if (other.num2 != null)
				return false;
		} else if (!num2.equals(other.num2))
			return false;
		if (num3 == null) {
			if (other.num3 != null)
				return false;
		} else if (!num3.equals(other.num3))
			return false;
		if (ticketNumber == null) {
			if (other.ticketNumber != null)
				return false;
		} else if (!ticketNumber.equals(other.ticketNumber))
			return false;
		if (ticketStatus == null) {
			if (other.ticketStatus != null)
				return false;
		} else if (!ticketStatus.equals(other.ticketStatus))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Integer ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public Integer getNum1() {
		return num1;
	}
	
	public void setNum1(Integer num1) {
		this.num1 = num1;
	}
	
	public Integer getNum2() {
		return num2;
	}
	
	public void setNum2(Integer num2) {
		this.num2 = num2;
	}
	
	public Integer getNum3() {
		return num3;
	}
	
	public void setNum3(Integer num3) {
		this.num3 = num3;
	}

	public Integer getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(Integer ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
}
