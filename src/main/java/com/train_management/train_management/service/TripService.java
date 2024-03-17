package com.train_management.train_management.service;

import com.train_management.train_management.model.Trip;
import com.train_management.train_management.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(Long tripId) {
        return tripRepository.findById(tripId);
    }

    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public void deleteTrip(Long tripId) {
        tripRepository.deleteById(tripId);
    }


    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    public Trip findById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id " + id));
    }

    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip update(Long tripId, Trip updatedTrip) {
        Trip existingTrip = findById(tripId); // Ensure the trip exists
        // Update the existing trip entity here based on updatedTrip's fields
        // For example, you might want to check each field for null and only update fields that have changed.
        return tripRepository.save(existingTrip);
    }

    public void delete(Long tripId) {
        tripRepository.deleteById(tripId);
    }
    // Additional business logic methods can be added here
    // For example, updating a trip, finding trips by routeId, etc.
}
