package com.parkinglot.service;

import com.parkinglot.model.*;
import com.parkinglot.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParkingService {
    @Autowired private SlotRepository slotRepository;

    public Slot assignSlot(VehicleType type) {
        List<Slot> available = slotRepository.findByIsOccupiedFalseAndSupportedVehicleType(type);
        if (available.isEmpty()) throw new RuntimeException("No available slots");
        Slot slot = available.get(0);
        slot.setOccupied(true);
        return slotRepository.save(slot);
    }

    public Slot releaseSlot(Long slotId) {
        Slot slot = slotRepository.findById(slotId).orElseThrow(() -> new RuntimeException("Slot not found"));
        slot.setOccupied(false);
        return slotRepository.save(slot);
    }

    public List<Slot> viewAllSlots() {
        return slotRepository.findAll();
    }
}
