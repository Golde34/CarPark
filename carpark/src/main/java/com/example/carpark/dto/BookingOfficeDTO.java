package com.example.carpark.dto;

import com.example.carpark.entities.Trip;
import lombok.Data;

import java.util.Date;

@Data
public class BookingOfficeDTO {
    private Long id;
    private String officeName;
    private String officePhone;
    private String officePlace;
    private double officePrice;
    private Date startContractDeadline;
    private Date endContractDeadline;
    private Trip trip;
}
