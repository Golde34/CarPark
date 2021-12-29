package com.example.carpark.controllers;

import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.dto.ParkingLotDTO;
import com.example.carpark.entities.Employee;
import com.example.carpark.entities.ParkingLot;
import com.example.carpark.service.interfaces.IParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parkingLotController")
public class ParkingLotController {
    @Autowired
    private IParkingLotService parkingLotService;

    @RequestMapping(value = "/addParkingLot", method = RequestMethod.POST)
    public ParkingLot addParkingLot(@RequestBody ParkingLotDTO parkingLotDTO) {
        ParkingLot parkingLotResponse = parkingLotService.saveParkingLot(parkingLotDTO);
        return parkingLotResponse;
    }

    @RequestMapping(value = "/displayParkingLot", method = RequestMethod.GET)
    public List<ParkingLotDTO> displayParkingLot() {
        List<ParkingLotDTO> listEmployeeResponse = parkingLotService.listParkingLotDto();
        return listEmployeeResponse;
    }

    @RequestMapping(value = "/editParkingLot/{id}", method = RequestMethod.POST)
    public ParkingLot editParkingLot(@PathVariable("id") int id, @RequestBody ParkingLotDTO parkingLotNewDTO) {
        ParkingLot parkingLotResponse = parkingLotService.editParkingLot(id, parkingLotNewDTO);
        return parkingLotResponse;
    }

    @RequestMapping(value = "/deleteParkingLot/{id}", method = RequestMethod.GET)
    public ParkingLot deleteParkingLot(@PathVariable("id") int id) {
        ParkingLot parkingLotResponse = parkingLotService.deleteParkingLot(id);
        return parkingLotResponse;
    }
}
