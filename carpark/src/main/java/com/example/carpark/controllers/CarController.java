package com.example.carpark.controllers;

import com.example.carpark.dto.CarDTO;
import com.example.carpark.entities.Car;
import com.example.carpark.service.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carController")
public class CarController {

    @Autowired
    private ICarService carService;

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public Car addCar(@RequestBody CarDTO carDTO) {
        Car carResponse = carService.saveCar(carDTO);
        return carResponse;
    }

    @RequestMapping(value = "/displayCar", method = RequestMethod.GET)
    public List<CarDTO> displayCar() {
        List<CarDTO> listCarResponse = carService.getAllCar();
        return listCarResponse;
    }
}
