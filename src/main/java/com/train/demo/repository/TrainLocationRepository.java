package com.train.demo.repository;

import com.train.demo.model.TrainLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainLocationRepository extends JpaRepository<TrainLocation, Long> {

    // Find the latest location update for a given train
    // Assuming 'timestamp' field exists and is used to determine the latest record
    default TrainLocation findLatestByTrainId(String trainId) {
        return findAllByTrainIdOrderByTimestampDesc(trainId).stream()
                .findFirst()
                .orElse(null);
    }

    // Find all location updates for a given train ordered by timestamp descending
    List<TrainLocation> findAllByTrainIdOrderByTimestampDesc(String trainId);
}
