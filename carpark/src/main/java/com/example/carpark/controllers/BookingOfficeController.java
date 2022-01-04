package com.example.carpark.controllers;

import com.example.carpark.dto.BookingOfficeDTO;
import com.example.carpark.entities.BookingOffice;
import com.example.carpark.entities.Employee;
import com.example.carpark.service.interfaces.IBookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookingOfficeController")
public class BookingOfficeController {

    @Autowired
    private IBookingOfficeService bookingOfficeService;

    @RequestMapping(value = "/bookingOfficeList", method = RequestMethod.GET)
    public List<BookingOfficeDTO> bookingOfficeDTOList() {
        List<BookingOfficeDTO> listBookingOfficeResponse = bookingOfficeService.bookingOfficeDtoList();
        return listBookingOfficeResponse;
    }

    @RequestMapping(value = "/addBookingOffice", method = RequestMethod.POST)
    public BookingOffice saveBookingOffice(@RequestBody BookingOfficeDTO bookingOfficeDTO) {
        BookingOffice bookingOfficeResponse = bookingOfficeService.saveBookingOfficeDTO(bookingOfficeDTO);
        return bookingOfficeResponse;
    }

    @PostMapping(value = "/viewOffice/{id}")
    public BookingOfficeDTO getBookingOfficeById(@PathVariable("id") long id) {
        BookingOfficeDTO bookingOfficeResponse = bookingOfficeService.getBookingOfficeDto(id);
        return bookingOfficeResponse;
    }
}