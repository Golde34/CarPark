package com.example.carpark.service.interfaces;

import com.example.carpark.dto.TicketDTO;
import com.example.carpark.entities.Ticket;

import java.util.List;

public interface ITicketService {
    List<TicketDTO> getAllTicket();
    Ticket saveTicket(TicketDTO ticketDTO);
    Ticket deleteTicket(long id);
    TicketDTO getTicketDto(long id);
    Ticket editTicket(long id, TicketDTO ticketDTO);
}
