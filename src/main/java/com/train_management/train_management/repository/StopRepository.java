package com.train_management.train_management.repository;

import com.train_management.train_management.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {
    // Example custom query to find stops by name
    List<Stop> findByStopNameContainingIgnoreCase(String stopName);

    // You can define more custom query methods as needed
}
