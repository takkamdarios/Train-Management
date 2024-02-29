package com.train_management.train_management.service;

import com.train_management.train_management.model.Agency;
import com.train_management.train_management.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {

    private final AgencyRepository agencyRepository;

    @Autowired
    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public List<Agency> findAll() {
        return agencyRepository.findAll();
    }

    public Optional<Agency> findById(Long id) {
        return agencyRepository.findById(id);
    }

    public Agency save(Agency agency) {
        return agencyRepository.save(agency);
    }

    public Agency update(Long id, Agency agencyDetails) {
        Agency existingAgency = agencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found with id: " + id));

        existingAgency.setAgencyName(agencyDetails.getAgencyName());
        existingAgency.setAgencyUrl(agencyDetails.getAgencyUrl());
        existingAgency.setAgencyTimezone(agencyDetails.getAgencyTimezone());
        existingAgency.setAgencyPhone(agencyDetails.getAgencyPhone());
        existingAgency.setAgencyLang(agencyDetails.getAgencyLang());

        return agencyRepository.save(existingAgency);
    }

    public void delete(Long id) {
        agencyRepository.deleteById(id);
    }
}
