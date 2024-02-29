package com.train_management.train_management.controller;

import com.train_management.model.Calendar;
import com.train_management.train_management.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    @Autowired
    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    // Get all calendar entries
    @GetMapping
    public ResponseEntity<List<Calendar>> getAllCalendarEntries() {
        List<Calendar> calendarEntries = calendarService.findAll();
        return ResponseEntity.ok(calendarEntries);
    }

    // Get a single calendar entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<Calendar> getCalendarById(@PathVariable Long id) {
        Calendar calendar = calendarService.findById(id);
        if (calendar != null) {
            return ResponseEntity.ok(calendar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new calendar entry
    @PostMapping
    public ResponseEntity<Calendar> createCalendarEntry(@RequestBody Calendar calendar) {
        Calendar savedCalendar = calendarService.save(calendar);
        return ResponseEntity.ok(savedCalendar);
    }

    // Update an existing calendar entry
    @PutMapping("/{id}")
    public ResponseEntity<Calendar> updateCalendarEntry(@PathVariable Long id, @RequestBody Calendar calendarDetails) {
        Calendar updatedCalendar = calendarService.update(id, calendarDetails);
        if (updatedCalendar != null) {
            return ResponseEntity.ok(updatedCalendar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a calendar entry
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalendarEntry(@PathVariable Long id) {
        calendarService.delete(id);
        return ResponseEntity.ok().build();
    }
}
