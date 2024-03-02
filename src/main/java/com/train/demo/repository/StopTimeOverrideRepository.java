package com.train.demo.repository;

import com.train.demo.model.StopTimeOverride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopTimeOverrideRepository extends JpaRepository<StopTimeOverride, Long> {
    // Here, you can define custom query methods if needed.
    // For example, to find all overrides for a specific trip:
     //List<StopTimeOverride> findByTripId(String tripId);
}
