package com.train_management.train_management.repository;

import com.train_management.train_management.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    // Here, you can define custom query methods as needed.
    // For example, finding routes by a specific name or characteristic:
    // List<Route> findByRouteShortName(String routeShortName);

    // Or finding routes that are operated by a specific agency:
    // List<Route> findByAgencyId(Long agencyId);
}
