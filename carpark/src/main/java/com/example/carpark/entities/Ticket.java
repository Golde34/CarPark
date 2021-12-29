package com.example.carpark.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "ticket_id", columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "booking_time")
    private Date bookingTimes;

    @Column(name = "customer_name")
    private String customerName;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "car_license", nullable = false)
    private Car car;
}
