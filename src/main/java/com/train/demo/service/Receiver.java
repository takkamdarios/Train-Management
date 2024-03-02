package com.train.demo.service;

import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public void receiveMessage(String message) {
        // Implement your message handling logic here
        System.out.println("Received <" + message + ">");
    }
}
