package com.example.carpark.controllers;

import com.example.carpark.dto.TicketDTO;
import com.example.carpark.entities.Ticket;
import com.example.carpark.service.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ticketController")
public class TicketController {
    @Autowired
    private ITicketService ticketService;

    @RequestMapping(value = "/addTicket", method = RequestMethod.POST)
    public Ticket addCar(@RequestBody TicketDTO ticketDTO) {
        Ticket carResponse = ticketService.saveTicket(ticketDTO);
        return carResponse;
    }

    @RequestMapping(value = "/displayTicket", method = RequestMethod.GET)
    public List<TicketDTO> displayTrip() {
        List<TicketDTO> listTripResponse = ticketService.getAllTicket();
        return listTripResponse;
    }
}
