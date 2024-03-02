package com.train.demo.repository;

import com.train.demo.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {
    // Example custom query to find stops by name
    List<Stop> findByStopNameContainingIgnoreCase(String stopName);

    // You can define more custom query methods as needed
}
