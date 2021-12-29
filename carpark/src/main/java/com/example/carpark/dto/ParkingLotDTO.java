package com.example.carpark.dto;

import com.example.carpark.entities.Car;
import lombok.Data;

import java.util.List;

@Data
public class ParkingLotDTO {
    private int id;
    private String name;
    private String area;
    private String place;
    private double price;
    private int status;
    private List<Car> car;
}
