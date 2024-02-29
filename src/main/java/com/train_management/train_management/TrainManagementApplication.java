package com.train_management.train_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.train_management.train_management.model"})
@EnableJpaRepositories(basePackages = {"com.train_management.train_management.repository"})
public class TrainManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainManagementApplication.class, args);
    }
}
