package com.example.carpark.controllers;

import com.example.carpark.dto.CarDTO;
import com.example.carpark.dto.ResponseModel;
import com.example.carpark.entities.Car;
import com.example.carpark.service.interfaces.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/carController")
public class CarController {

    @Autowired
    private ICarService carService;

    ResponseModel responseModel = new ResponseModel();

    @PostMapping(value = "/addCar")
    public ResponseModel<Car> addCar(@Valid @RequestBody CarDTO carDTO){
        carService.saveCar(carDTO);
        return responseModel;
    }

    @GetMapping(value = "/displayCar")
    public ResponseModel<List<CarDTO>> displayCar() {
        carService.getAllCar();
        return responseModel;
    }

    @GetMapping(value = "/viewCar/{id}")
    public ResponseModel<CarDTO> getCarById(@PathVariable("id") String license) {
        CarDTO car = carService.getCarDto(license);
        System.out.println(car.getLicense());
        return responseModel;
    }

    @PostMapping(value = "/editCar/{id}")
    public ResponseModel<Car> editCar(@PathVariable("id") String license, @RequestBody CarDTO carDTO) {
        carService.editCar(license, carDTO);
        return responseModel;
    }

    @GetMapping(value = "/deleteCar/{id}")
    public ResponseModel<Car> editCar(@PathVariable("id") String license) {
        carService.deleteCar(license);
        return responseModel;
    }
}
