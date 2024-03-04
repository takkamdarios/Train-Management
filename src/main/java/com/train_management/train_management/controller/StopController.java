package com.train_management.train_management.controller;

import com.train_management.train_management.model.Stop;
import com.train_management.train_management.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stops")
public class StopController {

    private final StopService stopService;

    @Autowired
    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @GetMapping
    public ResponseEntity<List<Stop>> getAllStops() {
        List<Stop> stops = stopService.findAll();
        return ResponseEntity.ok(stops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stop> getStopById(@PathVariable Long id) {
        Stop stop = stopService.findById(id);
        if (stop != null) {
            return ResponseEntity.ok(stop);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
