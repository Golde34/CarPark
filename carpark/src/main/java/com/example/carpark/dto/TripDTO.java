package com.example.carpark.dto;

import com.example.carpark.entities.BookingOffice;
import com.example.carpark.entities.Ticket;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
public class TripDTO {
    private int id;
    private int bookedNumber;
    private String carType;
    private Date departureDate;
    private Instant departureTime;
    private String destination;
    private String driver;
    private Integer maximumOnlineTicketNumber;
    private List<Ticket> tickets;
    private List<BookingOffice> offices;
}
