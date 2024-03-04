package com.train_management.train_management.controller;

import com.train_management.train_management.model.StopTimeOverride;
import com.train_management.train_management.service.StopTimeOverrideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stopTimeOverrides")
public class StopTimeOverrideController {

    private final StopTimeOverrideService stopTimeOverrideService;

    @Autowired
    public StopTimeOverrideController(StopTimeOverrideService stopTimeOverrideService) {
        this.stopTimeOverrideService = stopTimeOverrideService;
    }

    @PostMapping
    public ResponseEntity<StopTimeOverride> createStopTimeOverride(@RequestBody StopTimeOverride stopTimeOverride) {
        StopTimeOverride created = stopTimeOverrideService.createStopTimeOverride(stopTimeOverride);
        return ResponseEntity.ok(created);
    }

    // Additional endpoints (GET, PUT, DELETE) can be defined here
}
