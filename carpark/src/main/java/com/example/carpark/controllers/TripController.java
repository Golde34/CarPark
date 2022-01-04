package com.example.carpark.controllers;

import com.example.carpark.dto.CarDTO;
import com.example.carpark.dto.ResponseModel;
import com.example.carpark.dto.TripDTO;
import com.example.carpark.entities.Car;
import com.example.carpark.entities.Trip;
import com.example.carpark.service.interfaces.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tripController")
public class TripController {
    @Autowired
    private ITripService tripService;

    @RequestMapping(value = "/addTrip", method = RequestMethod.POST)
    public Trip addTrip(@RequestBody TripDTO tripDTO) {
        Trip tripResponse = tripService.saveTrip(tripDTO);
        return tripResponse;
    }

    @RequestMapping(value = "/displayTrip", method = RequestMethod.GET)
    public List<TripDTO> displayTrip() {
        List<TripDTO> listTripResponse = tripService.getAllTrip();
        return listTripResponse;
    }

    @GetMapping(value = "/viewTrip/{id}")
    public TripDTO getTripById(@PathVariable("id") int id) {
        TripDTO trip = tripService.getTripDto(id);
        return trip;
    }

    @PostMapping(value = "/editTrip/{id}")
    public Trip editTrip(@PathVariable("id") int id, @RequestBody TripDTO tripDTO) {
        Trip trip = tripService.editTrip(id, tripDTO);
        return trip;
    }

    @GetMapping(value = "/deleteTrip/{id}")
    public Trip deleteTrip(@PathVariable("id") int id) {
        Trip trip = tripService.deleteTrip(id);
        return trip;
    }
}
