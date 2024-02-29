package com.train_management.train_management.controller;

import com.train_management.train_management.model.Agency;
import com.train_management.train_management.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agencies")
public class AgencyController {

    private final AgencyService agencyService;

    @Autowired
    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping
    public ResponseEntity<List<Agency>> getAllAgencies() {
        List<Agency> agencies = agencyService.findAll();
        return ResponseEntity.ok(agencies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agency> getAgencyById(@PathVariable Long id) {
        Agency agency = agencyService.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found with id: " + id));
        return ResponseEntity.ok(agency);
    }

    @PostMapping
    public ResponseEntity<Agency> createAgency(@RequestBody Agency agency) {
        Agency newAgency = agencyService.save(agency);
        return new ResponseEntity<>(newAgency, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agency> updateAgency(@PathVariable Long id, @RequestBody Agency agencyDetails) {
        Agency updatedAgency = agencyService.update(id, agencyDetails);
        return ResponseEntity.ok(updatedAgency);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgency(@PathVariable Long id) {
        agencyService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
