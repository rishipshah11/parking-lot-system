package com.parkinglot.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Floor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int floorNumber;

    @ManyToOne
    private ParkingLot parkingLot;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<Slot> slots = new ArrayList<>();
}
