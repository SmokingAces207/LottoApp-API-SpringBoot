package com.josephocallaghan.lottoapp.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.josephocallaghan.lottoapp.domain.TicketLineEntity;

public interface TicketLineRepository extends PagingAndSortingRepository<TicketLineEntity, Integer> {

  List<TicketLineEntity> findByTicketNumber(@Param("ticketNo") final Integer ticketNo);

}
