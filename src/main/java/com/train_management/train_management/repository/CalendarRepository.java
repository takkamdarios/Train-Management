package com.train_management.train_management.repository;

import com.train_management.train_management.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, String> {
    // Repository methods go here

    // Example custom method (if you need any specific queries besides the CRUD operations provided by JpaRepository)
    // List<Calendar> findBySomeField(String someField);
}
