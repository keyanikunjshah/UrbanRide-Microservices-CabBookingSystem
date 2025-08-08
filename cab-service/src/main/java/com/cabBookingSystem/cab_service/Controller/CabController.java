package com.cabBookingSystem.cab_service.Controller;


import com.cabBookingSystem.cab_service.Entity.Cab;
import com.cabBookingSystem.cab_service.Entity.CabStatus;
import com.cabBookingSystem.cab_service.Service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cabs")
public class CabController {

    @Autowired
    private CabService cabService;

    @PostMapping("/register")
    public ResponseEntity<Cab> registerCab(@RequestBody Cab cab) {
        Cab savedCab = cabService.registerCab(cab);
        return ResponseEntity.ok(savedCab);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Cab>> getAvailableCabs(@RequestParam double latitude, @RequestParam double longitude) {
        List<Cab> availableCabs = cabService.getAvailableCabs(latitude, longitude);
        return ResponseEntity.ok(availableCabs);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Cab> updateCabStatus(@PathVariable Long id, @RequestParam CabStatus status) {
        Optional<Cab> updatedCab = cabService.updateCabStatus(id, status);
        return updatedCab.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/driver/{driverId}")
    public ResponseEntity<Cab> getCabByDriverId(@PathVariable Long driverId) {
        Optional<Cab> cab = cabService.getCabByDriverId(driverId);
        return cab.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }



}

