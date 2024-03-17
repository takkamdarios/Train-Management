package com.train_management.train_management.repository;

import com.train_management.train_management.model.StopTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopTimeRepository extends JpaRepository<StopTime, Long> {
    // Corrected method name for finding StopTime entities by the tripId of the Trip entity
    List<StopTime> findByTripTripId(Long tripId);
}
