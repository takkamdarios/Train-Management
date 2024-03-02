package com.train.demo.service;

import com.train.demo.model.Calendar;
import com.train.demo.repository.CalendarRepository;
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

    public Calendar saveCalendar(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public Optional<Calendar> getCalendarById(Long id) {
        return calendarRepository.findById(id);
    }

    public List<Calendar> getAllCalendars() {
        return calendarRepository.findAll();
    }

    public Calendar updateCalendar(Long id, Calendar calendarDetails) {
        Calendar calendar = calendarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendar not found with id " + id));

        calendar.setServiceId(calendarDetails.getServiceId());
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

    public void deleteCalendar(Long id) {
        Calendar calendar = calendarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calendar not found with id " + id));
        calendarRepository.delete(calendar);
    }



    public List<Calendar> findAll() {
        return calendarRepository.findAll();
    }

    public Calendar findById(Long id) {
        // Assuming Optional<Calendar> is returned; handle null case as per your application's needs
        return calendarRepository.findById(id).orElse(null);
    }

    public Calendar save(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public Calendar update(Long id, Calendar calendarDetails) {
        // Check if the calendar exists, update fields, and save
        Calendar calendar = calendarRepository.findById(id).orElse(null);
        if (calendar != null) {
            calendar.setServiceId(calendarDetails.getServiceId());
            calendar.setMonday(calendarDetails.getMonday());
            calendar.setTuesday(calendarDetails.getTuesday());
            calendar.setWednesday(calendarDetails.getWednesday());
            calendar.setThursday(calendarDetails.getThursday());
            calendar.setFriday(calendarDetails.getFriday());
            calendar.setSaturday(calendarDetails.getSaturday());
            calendar.setSunday(calendarDetails.getSunday());
            calendar.setStartDate(calendarDetails.getStartDate());
            calendar.setEndDate(calendarDetails.getEndDate());
            calendarRepository.save(calendar);
        }
        return calendar;
    }

    public void delete(Long id) {
        calendarRepository.deleteById(id);
    }
}
