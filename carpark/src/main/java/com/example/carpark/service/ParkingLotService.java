package com.example.carpark.service;

import com.example.carpark.dto.ParkingLotDTO;
import com.example.carpark.entities.Car;
import com.example.carpark.entities.ParkingLot;
import com.example.carpark.repo.ParkingLotRepository;
import com.example.carpark.service.interfaces.IParkingLotService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotService implements IParkingLotService {

    @Autowired
    private final ParkingLotRepository parkingLotRepository;
    @Autowired
    private ModelMapper mapper;
    public ParkingLotService(ParkingLotRepository parkingLotRepository, ModelMapper mapper) {
        this.parkingLotRepository = parkingLotRepository;
        this.mapper = mapper;
    }

    public ParkingLotDTO getParkingLot(int id) {
        Optional<ParkingLot> optParkingLot = parkingLotRepository.findById(id);
        if (optParkingLot.isPresent()) {
            ParkingLot parkingLot = optParkingLot.get();
            ParkingLotDTO parkingLotDTO = mapper.map(parkingLot, ParkingLotDTO.class);
            return parkingLotDTO;
        }
        return null;
    }

    @Override
    public List<ParkingLotDTO> listParkingLotDto() {
        List<ParkingLot> list =  parkingLotRepository.findAll();
        List<ParkingLotDTO> listParkingLotDTO = new ArrayList<>();
        for (ParkingLot lot: list) {
            ParkingLotDTO parkingLotDTO = mapper.map(lot, ParkingLotDTO.class);
            listParkingLotDTO.add(parkingLotDTO);
        }
        return listParkingLotDTO;
    }

    @Override
    public ParkingLot saveParkingLot(ParkingLotDTO parkingLotDTO) {
        ParkingLot parkingLot = mapper.map(parkingLotDTO, ParkingLot.class);
        parkingLotRepository.save(parkingLot);
        return parkingLot;
    }

    @Override
    public ParkingLot editParkingLot(int id, ParkingLotDTO parkingLotDTO) {
        ParkingLot parkingLot = mapper.map(parkingLotDTO, ParkingLot.class);
        parkingLot.setId(id);

        //add car again #Json car list null
        ParkingLotDTO oldParkingLotDTO = getParkingLot(id);
        ParkingLot oldParkingLot = mapper.map(oldParkingLotDTO, ParkingLot.class);
        List cars = new ArrayList();
        if (oldParkingLot.getCar() != null) {
            for (Car c : oldParkingLot.getCar()) {
                cars.add(c);
            }
            parkingLot.getCar().clear();
            parkingLot.getCar().addAll(cars);
        }
        parkingLotRepository.save(parkingLot);
        return parkingLot;
    }

    @Override
    public ParkingLot deleteParkingLot(int id) {
        ParkingLotDTO parkingLotDTO = getParkingLot(id);
        ParkingLot parkingLot = mapper.map(parkingLotDTO, ParkingLot.class);
        parkingLotRepository.delete(parkingLot);
        return parkingLot;
    }

    @Override
    public List<ParkingLotDTO> getParkingLotByParameter() {
        return null;
    }
}
