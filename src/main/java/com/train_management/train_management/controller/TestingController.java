package com.train_management.train_management.controller;

import com.train_management.train_management.service.WeatherDataFetchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testing")
public class TestingController {

    private final WeatherDataFetchingService weatherDataFetchingService;

    @Autowired
    public TestingController(WeatherDataFetchingService weatherDataFetchingService) {
        this.weatherDataFetchingService = weatherDataFetchingService;
    }

    @GetMapping("/triggerWeatherFetch")
    public ResponseEntity<String> triggerWeatherFetch() {
        weatherDataFetchingService.fetchWeatherAlerts();
        return ResponseEntity.ok("Weather fetching triggered!");
    }
}
