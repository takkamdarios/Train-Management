package com.train_management.train_management.service;

import com.train_management.train_management.model.WeatherAlertsResponse;
import com.train_management.train_management.model.WeatherAlert;
import com.train_management.train_management.repository.WeatherAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WeatherDataFetchingService {
    private static final Logger log = LoggerFactory.getLogger(WeatherDataFetchingService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherAlertRepository weatherAlertRepository;

    // Values should come from configuration or as method parameters
    private double lat = 38.0; // Example latitude
    private double lon = -78.25; // Example longitude
    private String apiKey = "fc8aa6775dfe4ed09e78bff4792e7b03"; // Securely store and retrieve your API key

    
    @Scheduled(cron = "0 * * * * *") // Runs every minute, adjust as needed
    public void fetchWeatherAlerts() {
        String url = "https://api.weatherbit.io/v2.0/alerts?lat=" + lat + "&lon=" + lon + "&key=" + apiKey;
        WeatherAlertsResponse response = restTemplate.getForObject(url, WeatherAlertsResponse.class);
        processWeatherAlerts(response);
    }

    private void processWeatherAlerts(WeatherAlertsResponse response) {
        // Implement the logic to process the response and save alerts to the database
    }
}

