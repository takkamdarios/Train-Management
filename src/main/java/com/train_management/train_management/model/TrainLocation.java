package com.train_management.train_management.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "train_locations") // Adjust table name as necessary
public class TrainLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "train_id", nullable = false)
    private String trainId;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "timestamp")
    private Instant timestamp;

    // Constructors
    public TrainLocation() {
    }

    public TrainLocation(String trainId, Double latitude, Double longitude, Instant timestamp) {
        this.trainId = trainId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    // toString method for logging
    @Override
    public String toString() {
        return "TrainLocation{" +
                "id=" + id +
                ", trainId='" + trainId + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp=" + timestamp +
                '}';
    }
}
