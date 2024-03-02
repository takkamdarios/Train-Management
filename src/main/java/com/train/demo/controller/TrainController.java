package com.train.demo.controller;

import com.train.demo.model.TrainLocation;
import com.train.demo.service.TrainLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/train")
public class TrainController {

    private final TrainLocationService trainLocationService;

    @Autowired
    public TrainController(TrainLocationService trainLocationService) {
        this.trainLocationService = trainLocationService;
    }

    @PostMapping("/{trainId}/location")
    public ResponseEntity<?> updateTrainLocation(@PathVariable String trainId, @RequestBody TrainLocation location) {
        // The TrainLocationService is responsible for handling the update logic,
        // which might include saving the location to a database and publishing a message to RabbitMQ.
        trainLocationService.updateLocation(trainId, location);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{trainId}/location")
    public ResponseEntity<TrainLocation> getTrainLocation(@PathVariable String trainId) {
        // The TrainLocationService is responsible for retrieving the current location of the train.
        TrainLocation location = trainLocationService.getCurrentLocation(trainId);

        if (location != null) {
            return ResponseEntity.ok(location);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
