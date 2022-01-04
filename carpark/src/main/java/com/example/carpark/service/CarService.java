package com.example.carpark.service;

import com.example.carpark.dto.CarDTO;
import com.example.carpark.entities.Car;
import com.example.carpark.entities.Ticket;
import com.example.carpark.exception.MyCustomException;
import com.example.carpark.repo.CarRepository;
import com.example.carpark.service.interfaces.ICarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService implements ICarService {

    @Autowired
    private final CarRepository carRepository;
    @Autowired
    private ModelMapper mapper;

    public CarService(CarRepository carRepository, ModelMapper mapper) {
        this.mapper = mapper;
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

    @Override
    public CarDTO getCarDto(String license) {
        Optional<Car> getCar = carRepository.findById(license);
        if (getCar.isPresent()) {
            Car car = getCar.get();
            CarDTO carDTO = mapper.map(car, CarDTO.class);
            return carDTO;
        }
        return null;
    }

    @Override
    public Car editCar(String license, CarDTO carDTO) {
        Car car = mapper.map(carDTO, Car.class);
        car.setLicense(license);
        List<Car> listCar = carRepository.findAll();
        int check = 0;
        for (Car c: listCar) {
            if(c.getLicense().equalsIgnoreCase(license)) {
                check = 1;
                break;
            }
        }
        if (check == 0) throw new MyCustomException("License plate does not exist!");
        else {
            carRepository.save(car);
        }
        return car;
    }

    @Override
    public Car deleteCar(String license) {
        carRepository.delete(carRepository.getById(license));
        return null;
    }
}
