package com.train_management.train_management.repository;

import com.train_management.train_management.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    // You can define custom methods here if needed, for example:
    // List<Trip> findByRouteId(Long routeId);
}
