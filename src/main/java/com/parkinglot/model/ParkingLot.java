package com.parkinglot.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class ParkingLot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL)
    private List<Floor> floors = new ArrayList<>();
}
