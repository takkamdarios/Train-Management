package com.train_management.train_management.config;

import org.springframework.stereotype.Service;

@Service
public class Receiver {

    public void receiveMessage(String message) {
        // Process the message here
        System.out.println("Received: " + message);
    }
}

