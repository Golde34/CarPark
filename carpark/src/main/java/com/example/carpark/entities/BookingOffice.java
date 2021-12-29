package com.example.carpark.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "bookingOffice")
public class BookingOffice {
    @Id
    @Column(name = "officeId", columnDefinition = "BIGINT(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "office_name")
    private String officeName;

    @Column(name = "office_phone")
    private String officePhone;

    @Column(name = "office_place")
    private String officePlace;

    @Column(name = "office_price")
    private double officePrice;

    @Column(name = "start_contract_deadline")
    private Date startContractDeadline;

    @Column(name = "end_contract_deadlinde")
    private Date endContractDeadline;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;
}
