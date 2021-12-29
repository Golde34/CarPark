package com.example.carpark.service.interfaces;

import com.example.carpark.dto.ParkingLotDTO;
import com.example.carpark.entities.ParkingLot;

import java.util.List;

public interface IParkingLotService {
    List<ParkingLotDTO> listParkingLotDto();
    ParkingLot saveParkingLot(ParkingLotDTO parkingLotDTO);
    ParkingLot editParkingLot(int id, ParkingLotDTO parkingLotDTO);
    ParkingLot deleteParkingLot(int id);
    List<ParkingLotDTO> getParkingLotByParameter();
}
