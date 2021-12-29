package com.example.carpark.service;

import com.example.carpark.dto.CarDTO;
import com.example.carpark.entities.Car;
import com.example.carpark.repo.CarRepository;
import com.example.carpark.service.interfaces.ICarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService implements ICarService {

    @Autowired
    private final CarRepository carRepository;
    ModelMapper mapper = new ModelMapper();
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDTO> getAllCar() {
        return carRepository.findAll().stream()
                .map(car -> mapper.map(car, CarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Car saveCar(CarDTO carDTO) {
        Car car = mapper.map(carDTO, Car.class);
        carRepository.save(car);
        return car;
    }
}
