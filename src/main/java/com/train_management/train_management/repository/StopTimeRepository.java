package com.train_management.train_management.repository;

import com.train_management.train_management.model.StopTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopTimeRepository extends JpaRepository<StopTime, Long> {
    // Example custom query method
    List<StopTime> findByTripId(String tripId);

    // Additional custom query methods can be defined here as needed
}
