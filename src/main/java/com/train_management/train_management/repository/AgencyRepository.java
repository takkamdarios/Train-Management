package com.train_management.train_management.repository;

import com.train_management.train_management.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
    // Here, you can add any custom methods you might need
    // For example, find an agency by name
    Agency findByName(String name);
}
