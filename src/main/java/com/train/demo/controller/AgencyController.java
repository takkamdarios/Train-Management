package com.train.demo.controller;

import com.train.demo.model.Agency;
import com.train.demo.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/agencies"})
public class AgencyController {
    @Autowired
    private AgencyService agencyService;

    public AgencyController() {
    }

    @GetMapping
    public ResponseEntity<List<Agency>> getAllAgencies() {
        List<Agency> agencies = this.agencyService.findAll();
        return ResponseEntity.ok(agencies);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Agency> getAgencyById(@PathVariable Long id) {
        Agency agency = (Agency)this.agencyService.findById(id).orElseThrow(() -> {
            return new RuntimeException("Agency not found with id: " + id);
        });
        return ResponseEntity.ok(agency);
    }

    @PostMapping
    public ResponseEntity<Agency> createAgency(@RequestBody Agency agency) {
        Agency newAgency = this.agencyService.save(agency);
        return new ResponseEntity(newAgency, HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Agency> updateAgency(@PathVariable Long id, @RequestBody Agency agencyDetails) {
        Agency updatedAgency = this.agencyService.update(id, agencyDetails);
        return ResponseEntity.ok(updatedAgency);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteAgency(@PathVariable Long id) {
        this.agencyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
