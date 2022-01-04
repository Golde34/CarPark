package com.example.carpark.service;

import com.example.carpark.dto.BookingOfficeDTO;
import com.example.carpark.dto.ParkingLotDTO;
import com.example.carpark.entities.BookingOffice;
import com.example.carpark.entities.ParkingLot;
import com.example.carpark.repo.BookingOfficeRepository;
import com.example.carpark.service.interfaces.IBookingOfficeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingOfficeService implements IBookingOfficeService {

    @Autowired
    private BookingOfficeRepository bookingOfficeRepository;
    @Autowired
    private ModelMapper mapper;

    public BookingOfficeService(BookingOfficeRepository bookingOfficeRepository, ModelMapper mapper) {
        this.bookingOfficeRepository = bookingOfficeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<BookingOfficeDTO> bookingOfficeDtoList() {
        List<BookingOffice> bookingOfficeList = bookingOfficeRepository.findAll();
        List<BookingOfficeDTO> list = new ArrayList<>();
        for (BookingOffice bookingOffice :bookingOfficeList) {
            BookingOfficeDTO bookingOfficeDTO = mapper.map(bookingOffice, BookingOfficeDTO.class);
            list.add(bookingOfficeDTO);
        }
        return list;
    }

    @Transactional
    public BookingOffice saveBookingOfficeDTO(BookingOfficeDTO bookingOfficeDTO){
        BookingOffice bookingOffice = mapper.map(bookingOfficeDTO, BookingOffice.class);
        bookingOfficeRepository.save(bookingOffice);
        return bookingOffice;
    }

    @Override
    public BookingOfficeDTO getBookingOfficeDto(long id) {
        Optional<BookingOffice> getBookingOffice = bookingOfficeRepository.findById(id);
        if (getBookingOffice.isPresent()) {
            BookingOffice bo = getBookingOffice.get();
            BookingOfficeDTO bookingOffice = mapper.map(bo, BookingOfficeDTO.class);
            return bookingOffice;
        }
        return null;
    }
}
