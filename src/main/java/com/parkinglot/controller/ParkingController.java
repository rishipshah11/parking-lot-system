package com.parkinglot.controller;

import com.parkinglot.model.*;
import com.parkinglot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {
    @Autowired private ParkingService parkingService;

    @PostMapping("/assign/{type}")
    public ResponseEntity<Slot> assignSlot(@PathVariable VehicleType type) {
        return ResponseEntity.ok(parkingService.assignSlot(type));
    }

    @PostMapping("/release/{slotId}")
    public ResponseEntity<Slot> releaseSlot(@PathVariable Long slotId) {
        return ResponseEntity.ok(parkingService.releaseSlot(slotId));
    }

    @GetMapping("/slots")
    public ResponseEntity<List<Slot>> getAllSlots() {
        return ResponseEntity.ok(parkingService.viewAllSlots());
    }
}
