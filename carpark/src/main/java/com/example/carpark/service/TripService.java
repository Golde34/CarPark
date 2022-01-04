package com.example.carpark.service;

import com.example.carpark.dto.TripDTO;
import com.example.carpark.entities.Car;
import com.example.carpark.entities.Trip;
import com.example.carpark.exception.MyCustomException;
import com.example.carpark.repo.TripRepository;
import com.example.carpark.service.interfaces.ITripService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripService implements ITripService {
    @Autowired
    private final TripRepository tripRepository;
    @Autowired
    private ModelMapper mapper;

    public TripService(TripRepository tripRepository, ModelMapper mapper) {
        this.tripRepository = tripRepository;
        this.mapper = mapper;
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

    @Override
    public TripDTO getTripDto(int id) {
        int check = checkExistTrip(id);
        if (check == 0)  throw new MyCustomException("Trip id does not exist!");
        else {
            Optional<Trip> getTrip = tripRepository.findById(id);
            if (getTrip.isPresent()) {
                Trip trip = getTrip.get();
                TripDTO tripDTO = mapper.map(trip, TripDTO.class);
                return tripDTO;
            }
            return null;
        }
    }

    @Override
    public Trip editTrip(int id, TripDTO tripDTO) {
        Trip trip = mapper.map(tripDTO, Trip.class);
        trip.setId(id);
        Trip oldTrip = tripRepository.getById(id);
        if(oldTrip.getTickets() != null && oldTrip.getOffices() != null) {
            trip.getOffices().addAll(oldTrip.getOffices());
            trip.getTickets().addAll(oldTrip.getTickets());
        }
        // Check Exist Trip
        int check = checkExistTrip(id);
        if (check == 0) throw new MyCustomException("Trip id does not exist!");
        else {
            tripRepository.save(trip);
        }
        return trip;
    }

    public int checkExistTrip(int id) {
        List<Trip> listTrip = tripRepository.findAll();
        int check = 0;
        for (Trip t: listTrip) {
            if(t.getId() == id) {
                check = 1;
                break;
            }
        }
        return check;
    }

    @Override
    public Trip deleteTrip(int id) {
        tripRepository.delete(tripRepository.getById(id));
        System.out.println("Deleted successfully");
        return null;
    }
}
