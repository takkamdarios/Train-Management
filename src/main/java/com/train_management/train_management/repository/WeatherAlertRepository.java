package com.train_management.train_management.repository;

import com.train_management.train_management.model.WeatherAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherAlertRepository extends JpaRepository<WeatherAlert, Long> {
    // Here, you can define custom methods if you need to perform complex queries.
    // For example, to find alerts by severity you would define:
    // List<WeatherAlert> findBySeverity(String severity);
}
