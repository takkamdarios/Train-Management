package com.train_management.train_management.repository;

import com.train_management.train_management.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    // Example custom query method to find services active on a specific date
    List<Calendar> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate date, LocalDate dateAgain);

    // Add more custom query methods as needed based on your application requirements
}
