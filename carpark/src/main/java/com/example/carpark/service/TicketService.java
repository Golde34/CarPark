package com.example.carpark.service;

import com.example.carpark.dto.TicketDTO;
import com.example.carpark.entities.Ticket;
import com.example.carpark.exception.MyCustomException;
import com.example.carpark.repo.TicketRepository;
import com.example.carpark.service.interfaces.ITicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private final TicketRepository ticketRepository;
    @Autowired
    private ModelMapper mapper;
    public TicketService (TicketRepository ticketRepository, ModelMapper mapper) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
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

    public TicketDTO getTicket(long id) {
        Optional<Ticket> optTicket = ticketRepository.findById(id);
        if (optTicket.isPresent()) {
            Ticket ticket = optTicket.get();
            TicketDTO ticketDTO = mapper.map(ticket, TicketDTO.class);
            return ticketDTO;
        }
        return null;
    }

    @Override
    public Ticket deleteTicket(long id) {
        TicketDTO ticketDTO = getTicket(id);
        Ticket ticket = mapper.map(ticketDTO, Ticket.class);
        ticketRepository.delete(ticket);
        return ticket;
    }

    public int checkExistTicket(long id) {
        List<Ticket> listTicket = ticketRepository.findAll();
        int check = 0;
        for (Ticket t: listTicket) {
            if(t.getId() == id) {
                check = 1;
                break;
            }
        }
        return check;
    }

    @Override
    public TicketDTO getTicketDto(long id) {
        int check = checkExistTicket(id);
        if (check == 0) throw new MyCustomException("Ticket id does not exist!");
        else {
            Optional<Ticket> getTicket = ticketRepository.findById(id);
            if (getTicket.isPresent()) {
                Ticket ticket = getTicket.get();
                TicketDTO ticketDTO = mapper.map(ticket, TicketDTO.class);
                return ticketDTO;
            }
            return null;
        }
    }

    @Override
    public Ticket editTicket(long id, TicketDTO ticketDTO) {
        Ticket ticket = mapper.map(ticketDTO, Ticket.class);
        ticket.setId(id);
        int check = checkExistTicket(id);
        if (check==0) throw new MyCustomException("Ticket id does not exist!");
        else {
            ticketRepository.save(ticket);
        }
        return ticket;
    }
}
