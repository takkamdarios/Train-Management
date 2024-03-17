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

    @GetMapping("/{trip_id}")
    public ResponseEntity<Trip> getTripById(@PathVariable("trip_id") Long tripId) {
        return ResponseEntity.ok(tripService.findById(tripId));
    }

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip) {
        return ResponseEntity.ok(tripService.save(trip));
    }

    @PutMapping("/{trip_id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable("trip_id") Long tripId, @RequestBody Trip trip) {
        return ResponseEntity.ok(tripService.update(tripId, trip));
    }

    @DeleteMapping("/{trip_id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable("trip_id") Long tripId) {
        tripService.delete(tripId);
        return ResponseEntity.noContent().build();
    }
}
