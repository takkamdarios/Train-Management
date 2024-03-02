package com.train.demo.service;

import com.train.demo.model.Stop;
import com.train.demo.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopService {

    private final StopRepository stopRepository;

    @Autowired
    public StopService(StopRepository stopRepository) {
        this.stopRepository = stopRepository;
    }

    // Fetch all stops
    public List<Stop> findAllStops() {
        return stopRepository.findAll();
    }

    // Find a stop by ID
    public Optional<Stop> findStopById(Long id) {
        return stopRepository.findById(id);
    }

    // Add a new stop
    public Stop addStop(Stop stop) {
        // Additional business logic can be added here
        return stopRepository.save(stop);
    }

    // Update an existing stop
    public Stop updateStop(Stop stop) {
        // Ensure the stop exists and then update it
        if (stop.getId() != null && stopRepository.existsById(stop.getId())) {
            return stopRepository.save(stop);
        }
        // Handle the case where the stop doesn't exist
        // This could throw an exception or return null
        return null;
    }

    // Delete a stop by ID
    public void deleteStopById(Long id) {
        stopRepository.deleteById(id);
    }

    public List<Stop> findAll() {
        return stopRepository.findAll();
    }

    public Stop findById(Long id) {
        Optional<Stop> stop = stopRepository.findById(id);
        return stop.orElse(null);
    }
}
