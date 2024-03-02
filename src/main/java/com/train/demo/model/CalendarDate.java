package com.train.demo.model;

import jakarta.persistence.*;

import jakarta.persistence.*;
import java.time.LocalDate;
//import java.util.Calendar;

@Entity
@Table(name = "calendar_dates")
public class CalendarDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Calendar calendar;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "exception_type")
    private Integer exceptionType; // 1 for service added, 2 for service removed

    // Standard getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(Integer exceptionType) {
        this.exceptionType = exceptionType;
    }

    // toString, hashCode, equals, and other methods (if necessary)
}
