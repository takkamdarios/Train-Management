package com.train_management.train_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.train_management.train_management.config.RestClientConfig;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final String apiUrl = "https://api.weatherbit.io/v2.0/alerts";

    @Value("${weatherbit.api.key}")
    private String weatherbitApiKey;

    private final RestTemplate restTemplate;

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeatherAlerts(double lat, double lon) {
        String url = apiUrl + "?lat=" + lat + "&lon=" + lon + "&key=" + weatherbitApiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
