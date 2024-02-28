package com.train_management.train_management.repository;

import com.train_management.train_management.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    // Define custom queries here if needed
}
