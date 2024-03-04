package com.train_management.train_management.service;

import com.train_management.train_management.model.StopTimeOverride;
import com.train_management.train_management.repository.StopTimeOverrideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopTimeOverrideService {

    private final StopTimeOverrideRepository stopTimeOverrideRepository;

    @Autowired
    public StopTimeOverrideService(StopTimeOverrideRepository stopTimeOverrideRepository) {
        this.stopTimeOverrideRepository = stopTimeOverrideRepository;
    }

    public StopTimeOverride createStopTimeOverride(StopTimeOverride stopTimeOverride) {
        // Additional logic before saving could be added here
        return stopTimeOverrideRepository.save(stopTimeOverride);
    }

    public Optional<StopTimeOverride> getStopTimeOverrideById(Long id) {
        return stopTimeOverrideRepository.findById(id);
    }

    public List<StopTimeOverride> getAllStopTimeOverrides() {
        return stopTimeOverrideRepository.findAll();
    }

    public StopTimeOverride updateStopTimeOverride(Long id, StopTimeOverride stopTimeOverrideDetails) {
        StopTimeOverride stopTimeOverride = stopTimeOverrideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StopTimeOverride not found for this id :: " + id));

        stopTimeOverride.setTripId(stopTimeOverrideDetails.getTripId());
        stopTimeOverride.setDate(stopTimeOverrideDetails.getDate());
        stopTimeOverride.setStopId(stopTimeOverrideDetails.getStopId());
        stopTimeOverride.setArrivalTime(stopTimeOverrideDetails.getArrivalTime());
        stopTimeOverride.setDepartureTime(stopTimeOverrideDetails.getDepartureTime());
        stopTimeOverride.setExceptionType(stopTimeOverrideDetails.getExceptionType());

        final StopTimeOverride updatedStopTimeOverride = stopTimeOverrideRepository.save(stopTimeOverride);
        return updatedStopTimeOverride;
    }

    public void deleteStopTimeOverride(Long id) {
        StopTimeOverride stopTimeOverride = stopTimeOverrideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StopTimeOverride not found for this id :: " + id));

        stopTimeOverrideRepository.delete(stopTimeOverride);
    }
}
