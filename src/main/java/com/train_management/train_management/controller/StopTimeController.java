package com.train_management.train_management.controller;

import com.train_management.train_management.model.StopTime;
import com.train_management.train_management.service.StopTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stopTimes")
public class StopTimeController {

    private final StopTimeService stopTimeService;

    @Autowired
    public StopTimeController(StopTimeService stopTimeService) {
        this.stopTimeService = stopTimeService;
    }

    @PostMapping
    public ResponseEntity<StopTime> createStopTime(@RequestBody StopTime stopTime) {
        StopTime created = stopTimeService.createStopTime(stopTime);
        return ResponseEntity.ok(created);
    }

    // Additional endpoints (GET, PUT, DELETE) can be defined here
}
