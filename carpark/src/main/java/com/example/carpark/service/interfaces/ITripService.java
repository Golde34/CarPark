package com.example.carpark.service.interfaces;

import com.example.carpark.dto.CarDTO;
import com.example.carpark.dto.TripDTO;
import com.example.carpark.entities.Car;
import com.example.carpark.entities.Trip;

import java.util.List;

public interface ITripService {
    List<TripDTO> getAllTrip();
    Trip saveTrip(TripDTO tripDTO);
}
