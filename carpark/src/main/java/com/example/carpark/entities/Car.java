package com.example.carpark.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "license_plate")
    private String license;

    @Column(name = "car_type")
    private String type;

    @Column(name = "car_color")
    private String color;

    @Column(name = "company")
    private String company;

    @ManyToOne
    @JoinColumn(name = "park_id", nullable = false)
    private ParkingLot parkingLot;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car", orphanRemoval = true)
    @JsonIgnore
    private List<Ticket> ticket;

}
