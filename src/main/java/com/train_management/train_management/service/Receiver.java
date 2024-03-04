package com.train_management.train_management.service;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public void receiveMessage(String message) {
        // Implement your message handling logic here
        System.out.println("Received <" + message + ">");
    }
}
