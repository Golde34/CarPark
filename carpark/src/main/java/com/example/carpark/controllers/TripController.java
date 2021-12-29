package com.example.carpark.controllers;

import com.example.carpark.dto.CarDTO;
import com.example.carpark.dto.TripDTO;
import com.example.carpark.entities.Car;
import com.example.carpark.entities.Trip;
import com.example.carpark.service.interfaces.ICarService;
import com.example.carpark.service.interfaces.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tripController")
public class TripController {
    @Autowired
    private ITripService tripService;

    @RequestMapping(value = "/addTrip", method = RequestMethod.POST)
    public Trip addCar(@RequestBody TripDTO tripDTO) {
        Trip carResponse = tripService.saveTrip(tripDTO);
        return carResponse;
    }

    @RequestMapping(value = "/displayTrip", method = RequestMethod.GET)
    public List<TripDTO> displayTrip() {
        List<TripDTO> listTripResponse = tripService.getAllTrip();
        return listTripResponse;
    }
}
