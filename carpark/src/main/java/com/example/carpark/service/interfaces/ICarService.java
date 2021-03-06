package com.example.carpark.service.interfaces;

import com.example.carpark.dto.CarDTO;
import com.example.carpark.entities.Car;

import java.util.List;

public interface ICarService {
    List<CarDTO> getAllCar();
    Car saveCar(CarDTO carDTO);
    CarDTO getCarDto(String license);
    Car editCar(String license, CarDTO carDTO);
    Car deleteCar(String license);
}
