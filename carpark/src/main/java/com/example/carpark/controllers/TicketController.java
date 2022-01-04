package com.example.carpark.controllers;

import com.example.carpark.dto.TicketDTO;
import com.example.carpark.dto.TripDTO;
import com.example.carpark.entities.Ticket;
import com.example.carpark.entities.Trip;
import com.example.carpark.service.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ticketController")
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    @RequestMapping(value = "/addTicket", method = RequestMethod.POST)
    public Ticket addTicket(@RequestBody TicketDTO ticketDTO) {
        Ticket ticketResponse = ticketService.saveTicket(ticketDTO);
        return ticketResponse;
    }

    @RequestMapping(value = "/displayTicket", method = RequestMethod.GET)
    public List<TicketDTO> displayTicket() {
        List<TicketDTO> listTicketResponse = ticketService.getAllTicket();
        return listTicketResponse;
    }

    @RequestMapping(value = "/deleteTicket/{id}", method = RequestMethod.GET)
    public Ticket deleteTicket(@PathVariable("id") long id) {
        Ticket ticketResponse = ticketService.deleteTicket(id);
        return ticketResponse;
    }

    @GetMapping(value = "/viewTicket/{id}")
    public TicketDTO getTicketById(@PathVariable("id") long id) {
        TicketDTO trip = ticketService.getTicketDto(id);
        return trip;
    }

    @PostMapping(value = "/editTicket/{id}")
    public Ticket editTicket(@PathVariable("id") long id, @RequestBody TicketDTO ticketDTO) {
        Ticket trip = ticketService.editTicket(id, ticketDTO);
        return trip;
    }
}
