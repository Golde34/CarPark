package com.example.carpark.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "parking_lot")
public class ParkingLot {

    @Id
    @Column(name = "park_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "park_name")
    private String name;

    @Column(name = "park_area")
    private String area;

    @Column(name = "park_place")
    private String place;

    @Column(name = "park_price")
    private double price;

    @Column(name = "park_status")
    private int status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parkingLot", orphanRemoval = true)
    @JsonIgnore
    private List<Car> car;
}
