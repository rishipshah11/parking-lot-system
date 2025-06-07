package com.parkinglot.repository;

import com.parkinglot.model.Slot;
import com.parkinglot.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {
    List<Slot> findByIsOccupiedFalseAndSupportedVehicleType(VehicleType type);
}
