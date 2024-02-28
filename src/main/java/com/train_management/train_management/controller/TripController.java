package com.train_management.train_management.controller;

import com.train_management.train_management.model.Trip;
import com.train_management.train_management.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAllTrips() {
        return ResponseEntity.ok(tripService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        return ResponseEntity.ok(tripService.save(trip));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip trip) {
        return ResponseEntity.ok(tripService.update(id, trip));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        tripService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
