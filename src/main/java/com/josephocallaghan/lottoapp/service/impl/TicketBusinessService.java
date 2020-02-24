package com.josephocallaghan.lottoapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.josephocallaghan.lottoapp.domain.TicketEntity;
import com.josephocallaghan.lottoapp.domain.TicketLineEntity;
import com.josephocallaghan.lottoapp.dto.TicketDto;
import com.josephocallaghan.lottoapp.dto.TicketLineDto;
import com.josephocallaghan.lottoapp.service.BaseBusinessService;
import com.josephocallaghan.lottoapp.service.ITicketBusinessService;

@Service
public class TicketBusinessService extends BaseBusinessService implements ITicketBusinessService {
	
	@Override
	public TicketDto createTicket(final Integer numOfLines) {
		
		List<TicketLineDto> ticketLines = new ArrayList<>();
		List<TicketLineEntity> entityListToSave = new ArrayList<>();
		
		// Create new ticket and ticket lines
		TicketEntity ticketEntity = ticketRepository.save(new TicketEntity());
		
		// Pick random lotto numbers for ticket for each line
		for (Integer i = 1; i <= numOfLines; i++) { 
			
			Random rand = new Random();
			
			TicketLineEntity entity = new TicketLineEntity();
			entity.setNum1(rand.nextInt(3));
			entity.setNum2(rand.nextInt(3));
			entity.setNum3(rand.nextInt(3));
			entity.setTicketNumber(ticketEntity.getTicketNumber());
			
			entityListToSave.add(entity);
		}
		
		ticketLineRepository.saveAll(entityListToSave);
		
		for (TicketLineEntity entity : entityListToSave) {
			TicketLineDto dto = new TicketLineDto(entity);
			ticketLines.add(dto);
		}
		
		TicketDto ticket = new TicketDto(ticketLines);
		return ticket;
	}

	@Override
	public List<TicketDto> getAllTickets() {
		
		Iterable<TicketLineEntity> ticketLineEntityList = ticketLineRepository.findAll();
		List<TicketLineDto> ticketLineList = new ArrayList<>();
		List<TicketDto> ticketList = new ArrayList<>();
		
		Integer prevTicketNumber = null;
		
		for (TicketLineEntity line : ticketLineEntityList) {
			
			// Ticket line numbers changed - Store all lines in a new ticket
			if (Objects.nonNull(prevTicketNumber) && prevTicketNumber != line.getTicketNumber()) {
				
				// Create new ticket from ticket line list
				TicketDto ticket = new TicketDto(ticketLineList);
				ticketList.add(ticket);
				
				ticketLineList = new ArrayList<>();
				// Create ticket line DTO from ticket entity
				TicketLineDto ticketLine = new TicketLineDto(line);
				ticketLineList.add(ticketLine);
				
			} else {
				
				// Create ticket line DTO from ticket entity
				TicketLineDto ticketLine = new TicketLineDto(line);
				ticketLineList.add(ticketLine);
				
			}
			prevTicketNumber = line.getTicketNumber();
		}
		
		// Our final list will not be created in our loop. So we create it here
		TicketDto ticket = new TicketDto(ticketLineList);
		ticketList.add(ticket);
		return ticketList;
	}

	@Override
	public TicketDto getTicketByTicketNo(final Integer ticketNo) {
		
		List<TicketLineDto> ticketLines = new ArrayList<>();
		List<TicketLineEntity> ticketLineEntityList = ticketLineRepository.findByTicketNumber(ticketNo);
		
		if (ticketLineEntityList.isEmpty()) {
			throw new EntityNotFoundException("Could not find ticket with ID no: " + ticketNo);
		}
			
		for (TicketLineEntity entity : ticketLineEntityList) {
			TicketLineDto dto = new TicketLineDto(entity);
			ticketLines.add(dto);
		}
		
		TicketDto ticket = new TicketDto(ticketLines);
		return ticket;
	}

	@Override
	public TicketDto ammedTicket(final Integer ticketNo, final Integer numOfLines) {

		List<TicketLineDto> ticketLines = new ArrayList<>();
		List<TicketLineEntity> entityListToSave = new ArrayList<>();
		
		// Get existing ticket
		Optional<TicketEntity> ticketEntity = ticketRepository.findById(ticketNo);
		
		if (ticketEntity.isPresent()) {
			
			// Pick random lotto numbers for ticket for each line
			for (Integer i = 1; i <= numOfLines; i++) { 
				
				Random rand = new Random();
				
				TicketLineEntity entity = new TicketLineEntity();
				entity.setNum1(rand.nextInt(3));
				entity.setNum2(rand.nextInt(3));
				entity.setNum3(rand.nextInt(3));
				entity.setTicketNumber(ticketEntity.get().getTicketNumber());
				
				entityListToSave.add(entity);
			}
				
		} else {
			throw new EntityNotFoundException("Could not find ticket with ID no: " + ticketNo);
		}
		
		// Save new ticket lines
		ticketLineRepository.saveAll(entityListToSave);
		
		// Get all existing and new tickets from DB
		List<TicketLineEntity> ticketLineEntityList = ticketLineRepository.findByTicketNumber(ticketNo);
		for (TicketLineEntity entity : ticketLineEntityList) {
			TicketLineDto dto = new TicketLineDto(entity);
			ticketLines.add(dto);
		}
		
		TicketDto ticket = new TicketDto(ticketLines);
		return ticket;
	}
	
	@Override
	public TicketDto calculateTicketStatus(final Integer ticketNo) {
		
		ArrayList<TicketLineDto> ticketLines = new ArrayList<>();
		
		List<TicketLineEntity> ticketLineEntityList = ticketLineRepository.findByTicketNumber(ticketNo);
		Optional<TicketEntity> ticketEntity = ticketRepository.findById(ticketNo);
		
		if (ticketEntity.isEmpty()) {
			throw new EntityNotFoundException("Could not find ticket with ID no: " + ticketNo);
		}
		
		// For each line, calculate the line status based on the following criteria
		for (TicketLineEntity line : ticketLineEntityList) {
		
			line.setTicketStatus(ticketStatusHelper(line));
			
			// Create ticket line DTO from entity
			TicketLineDto dto = new TicketLineDto(line);
			ticketLines.add(dto);
		}
		
		// Status ticket checked flag to true
		ticketEntity.get().setChecked(Boolean.TRUE);
		ticketRepository.save(ticketEntity.get());
		
		TicketDto ticket = new TicketDto(ticketLines);
		ticket.setChecked(Boolean.TRUE);
		return ticket;
	}
	
	public Integer ticketStatusHelper(final TicketLineEntity line) {
		
		Integer result = 0;
		
		if ((line.getNum1() + line.getNum2() + line.getNum3()) == 2) {
			result = 10;
			
		} else if (line.getNum1() == line.getNum2() && line.getNum1() == line.getNum3()) {
			result = 5;
			
		} else if (line.getNum1() != line.getNum2() && line.getNum1() != line.getNum3()) {
			result = 1;
		}
		
		return result;
	}
	
}