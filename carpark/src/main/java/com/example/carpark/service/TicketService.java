package com.example.carpark.service;

import com.example.carpark.dto.TicketDTO;
import com.example.carpark.dto.TripDTO;
import com.example.carpark.entities.Ticket;
import com.example.carpark.entities.Trip;
import com.example.carpark.repo.TicketRepository;
import com.example.carpark.service.interfaces.ITicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private final TicketRepository ticketRepository;
    ModelMapper mapper = new ModelMapper();
    public TicketService (TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketDTO> getAllTicket() {
        return ticketRepository.findAll().stream()
                .map(ticket -> mapper.map(ticket, TicketDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Ticket saveTicket(TicketDTO ticketDTO) {
        Ticket ticket = mapper.map(ticketDTO, Ticket.class);
        ticketRepository.save(ticket);
        return ticket;
    }
}
