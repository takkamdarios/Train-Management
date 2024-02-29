package com.train_management;

import com.train_management.train_management.model.TrainLocation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TrainManagementApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendAndReceiveMessage() {
        // Simulate POST request to update train location
        TrainLocation location = new TrainLocation("train123", 40.0, -74.0, Instant.now());
        ResponseEntity<?> response = restTemplate.postForEntity("/api/train/train123/location", location, null);

        // Assert the response status code
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Retrieve message from RabbitMQ
        TrainLocation receivedLocation = (TrainLocation) rabbitTemplate.receiveAndConvert("train_location_queue");

        // Assert the message content
        assertThat(receivedLocation).isNotNull();
        assertThat(receivedLocation.getTrainId()).isEqualTo("train123");
    }
}
