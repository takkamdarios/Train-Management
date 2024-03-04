package com.train_management.train_management.service;

import com.train_management.train_management.model.Route;
import com.train_management.train_management.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }


    // Retrieve a single route by ID
    public Optional<Route> findRouteById(Long id) {
        return routeRepository.findById(id);
    }

    // Save or update a route
    public Route saveOrUpdateRoute(Route route) {
        return routeRepository.save(route);
    }

    // Delete a route
    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }


    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    public Route findById(Long id) {
        Optional<Route> route = routeRepository.findById(id);
        return route.orElse(null);
    }
}
