package com.example.carpark.service;

import com.example.carpark.dto.CarDTO;
import com.example.carpark.dto.TripDTO;
import com.example.carpark.entities.Car;
import com.example.carpark.entities.Trip;
import com.example.carpark.repo.CarRepository;
import com.example.carpark.repo.TripRepository;
import com.example.carpark.service.interfaces.ITripService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripService implements ITripService {
    @Autowired
    private final TripRepository tripRepository;
    ModelMapper mapper = new ModelMapper();
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<TripDTO> getAllTrip() {
        return tripRepository.findAll().stream()
                .map(trip -> mapper.map(trip, TripDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Trip saveTrip(TripDTO tripDTO) {
        Trip trip = mapper.map(tripDTO, Trip.class);
        tripRepository.save(trip);
        return trip;
    }
}
