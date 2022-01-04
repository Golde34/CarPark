package com.example.carpark.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Trip")
public class Trip {
    @Id
    @Column(name = "trip_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "booked_ticket_number")
    private int bookedNumber;

    @Column(name = "car_type")
    private String carType;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "departure_time")
    private Instant departureTime;

    @Column(name = "destination")
    private String destination;

    @Column(name = "driver")
    private String driver;

    @Column(name = "maximum_online_ticket_number")
    private Integer maximumOnlineTicketNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip", orphanRemoval = true)
    @JsonIgnore
    private List<Ticket> tickets;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip", orphanRemoval = true)
    @JsonIgnore
    private List<BookingOffice> offices;
}
