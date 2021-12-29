package com.example.carpark.dto;

import com.example.carpark.entities.Car;
import com.example.carpark.entities.Trip;
import lombok.Data;

import java.util.Date;

@Data
public class TicketDTO {
    private Date bookingTimes;
    private String customerName;
    private Trip trip;
    private Car car;
}
