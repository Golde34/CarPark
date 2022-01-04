package com.example.carpark.service.interfaces;

import com.example.carpark.dto.TripDTO;
import com.example.carpark.entities.Trip;

import java.util.List;

public interface ITripService {
    List<TripDTO> getAllTrip();
    Trip saveTrip(TripDTO tripDTO);
    TripDTO getTripDto(int id);
    Trip editTrip(int id, TripDTO tripDTO);
    Trip deleteTrip(int id);
}
