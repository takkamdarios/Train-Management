package com.train_management.train_management.service;

import com.train_management.train_management.model.Calendar;
import com.train_management.train_management.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {

    private final CalendarRepository calendarRepository;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    // Save or create a new Calendar entry
    public Calendar save(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    // Get a Calendar entry by serviceId
    public Optional<Calendar> findByServiceId(String serviceId) {
        return calendarRepository.findById(serviceId);
    }

    // Get all Calendar entries
    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    // Update a Calendar entry
    public Calendar update(String serviceId, Calendar calendarDetails) {
        Calendar calendar = calendarRepository.findById(serviceId)
                .orElseThrow(() -> new IllegalStateException("Calendar with serviceId " + serviceId + " not found"));

        // Update fields from calendarDetails to calendar
        calendar.setMonday(calendarDetails.getMonday());
        calendar.setTuesday(calendarDetails.getTuesday());
        calendar.setWednesday(calendarDetails.getWednesday());
        calendar.setThursday(calendarDetails.getThursday());
        calendar.setFriday(calendarDetails.getFriday());
        calendar.setSaturday(calendarDetails.getSaturday());
        calendar.setSunday(calendarDetails.getSunday());
        calendar.setStartDate(calendarDetails.getStartDate());
        calendar.setEndDate(calendarDetails.getEndDate());

        return calendarRepository.save(calendar);
    }

    // Delete a Calendar entry by serviceId
    public void deleteByServiceId(String serviceId) {
        calendarRepository.deleteById(serviceId);
    }
}
