package com.example.carpark.service;

import com.example.carpark.dto.BookingOfficeDTO;
import com.example.carpark.entities.BookingOffice;
import com.example.carpark.entities.Employee;
import com.example.carpark.repo.BookingOfficeRepository;
import com.example.carpark.service.interfaces.IBookingOfficeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingOfficeService implements IBookingOfficeService {

    @Autowired
    private final BookingOfficeRepository bookingOfficeRepository;
    ModelMapper mapper = new ModelMapper();
    public BookingOfficeService(BookingOfficeRepository bookingOfficeRepository) {
        this.bookingOfficeRepository = bookingOfficeRepository;
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
}
