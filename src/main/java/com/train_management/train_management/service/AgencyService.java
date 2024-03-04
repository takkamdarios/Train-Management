package com.train_management.train_management.service;

import com.train_management.train_management.model.Agency;
import com.train_management.train_management.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {
    @Autowired
    private AgencyRepository agencyRepository;

    public AgencyService() {
    }

    public List<Agency> findAll() {
        return this.agencyRepository.findAll();
    }

    public Optional<Agency> findById(Long id) {
        return this.agencyRepository.findById(id);
    }

    public Agency save(Agency agency) {
        return (Agency)this.agencyRepository.save(agency);
    }

    public Agency update(Long id, Agency agencyDetails) {
        Agency existingAgency = (Agency)this.agencyRepository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Agency not found with id: " + id);
        });
        existingAgency.setAgencyName(agencyDetails.getAgencyName());
        existingAgency.setAgencyUrl(agencyDetails.getAgencyUrl());
        existingAgency.setAgencyTimezone(agencyDetails.getAgencyTimezone());
        existingAgency.setAgencyPhone(agencyDetails.getAgencyPhone());
        existingAgency.setAgencyLang(agencyDetails.getAgencyLang());
        return (Agency)this.agencyRepository.save(existingAgency);
    }

    public void delete(Long id) {
        this.agencyRepository.deleteById(id);
    }
}
