package com.train_management.train_management.service;

import com.train_management.train_management.model.TrainLocation;
import com.train_management.train_management.repository.TrainLocationRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class TrainLocationService {

    private final TrainLocationRepository trainLocationRepository;
    private final RabbitTemplate rabbitTemplate;

    // RabbitMQ exchange and routing key can be defined here or in the application.properties
    private static final String TRAIN_LOCATION_EXCHANGE = "train_location_exchange";
    private static final String TRAIN_LOCATION_ROUTING_KEY = "train_location_routing_key";

    @Autowired
    public TrainLocationService(TrainLocationRepository trainLocationRepository, RabbitTemplate rabbitTemplate) {
        this.trainLocationRepository = trainLocationRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Transactional
    public void updateLocation(String trainId, TrainLocation location) {
        // You might want to perform some checks or business logic before saving the location
        // Save the train location to the database
        location.setTrainId(trainId); // Ensure the trainId is set from the path variable
        trainLocationRepository.save(location);

        // Then, publish the location update to the RabbitMQ exchange
        rabbitTemplate.convertAndSend(TRAIN_LOCATION_EXCHANGE, TRAIN_LOCATION_ROUTING_KEY, location);
    }

    public TrainLocation getCurrentLocation(String trainId) {
        // Retrieve the latest location of the train from the database
        // This method calls the custom method we defined in the TrainLocationRepository
        return trainLocationRepository.findLatestByTrainId(trainId);
    }



}
