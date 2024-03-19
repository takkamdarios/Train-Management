package com.train_management.train_management.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherAlertsResponse {

    private double lat;
    private double lon;
    private List<WeatherAlert> alerts;

    // Default constructor
    public WeatherAlertsResponse() {}

    // Getters and Setters
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public List<WeatherAlert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<WeatherAlert> alerts) {
        this.alerts = alerts;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WeatherAlert {
        private String title;
        private String description;
        private String severity;

        @JsonProperty("effective_utc")
        private String effectiveUtc;

        @JsonProperty("effective_local")
        private String effectiveLocal;

        @JsonProperty("expires_utc")
        private String expiresUtc;

        @JsonProperty("expires_local")
        private String expiresLocal;

        private String uri;
        private List<String> regions;
    }
}
