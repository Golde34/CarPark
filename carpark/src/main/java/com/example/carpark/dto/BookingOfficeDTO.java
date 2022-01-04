package com.example.carpark.dto;

import com.example.carpark.constants.RegexValidate;
import com.example.carpark.entities.Trip;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class BookingOfficeDTO {
    private Long id;
    private String officeName;

    @NotBlank
    @Pattern(regexp = RegexValidate.PHONE_REGEX, message = "Invalid phone, 10-11 number, start with 03 or 09")
    private String officePhone;

    private String officePlace;
    private double officePrice;
    private Date startContractDeadline;
    private Date endContractDeadline;
    private Trip trip;
}
