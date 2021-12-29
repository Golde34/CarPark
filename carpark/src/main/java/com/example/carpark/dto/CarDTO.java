package com.example.carpark.dto;

import com.example.carpark.entities.ParkingLot;
import com.example.carpark.entities.Ticket;
import lombok.Data;

import java.util.List;

@Data
public class CarDTO {
    private String license;
    private String type;
    private String color;
    private String company;
    private ParkingLot parkingLot;
}
