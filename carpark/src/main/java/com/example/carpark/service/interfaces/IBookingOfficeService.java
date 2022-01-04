package com.example.carpark.service.interfaces;

import com.example.carpark.dto.BookingOfficeDTO;
import com.example.carpark.entities.BookingOffice;

import java.util.List;

public interface IBookingOfficeService {
    List<BookingOfficeDTO> bookingOfficeDtoList();
    BookingOffice saveBookingOfficeDTO(BookingOfficeDTO bookingOfficeDTO);
    BookingOfficeDTO getBookingOfficeDto(long id);
}
