package com.train_management.train_management.service;

import com.train_management.train_management.model.StopTime;
import com.train_management.train_management.repository.StopTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopTimeService {

    private final StopTimeRepository stopTimeRepository;

    @Autowired
    public StopTimeService(StopTimeRepository stopTimeRepository) {
        this.stopTimeRepository = stopTimeRepository;
    }

    // Fetch all stop times
    public List<StopTime> findAllStopTimes() {
        return stopTimeRepository.findAll();
    }

    // Fetch a specific stop time by ID
    public Optional<StopTime> findStopTimeById(Long id) {
        return stopTimeRepository.findById(id);
    }

    // Save or update a stop time
    public StopTime saveOrUpdateStopTime(StopTime stopTime) {
        return stopTimeRepository.save(stopTime);
    }

    // Delete a stop time by ID
    public void deleteStopTimeById(Long id) {
        stopTimeRepository.deleteById(id);
    }

    // Additional methods to handle business logic related to stop times
    // This could include searching by tripId, stopId, time ranges, etc.
}
