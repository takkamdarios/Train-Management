package com.train_management.train_management.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendLocationUpdate(String locationData) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.topicExchangeName, "train.location.updated", locationData);
    }
}

