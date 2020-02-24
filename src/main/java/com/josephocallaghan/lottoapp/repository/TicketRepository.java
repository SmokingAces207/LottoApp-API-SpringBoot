package com.josephocallaghan.lottoapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.josephocallaghan.lottoapp.domain.TicketEntity;

public interface TicketRepository extends PagingAndSortingRepository<TicketEntity, Integer> {

}
