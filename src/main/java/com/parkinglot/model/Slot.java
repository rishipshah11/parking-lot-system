package com.parkinglot.model;

import jakarta.persistence.*;

@Entity
public class Slot {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int slotNumber;

    @Enumerated(EnumType.STRING)
    private VehicleType supportedVehicleType;

    private boolean isOccupied;

    @ManyToOne
    private Floor floor;

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
