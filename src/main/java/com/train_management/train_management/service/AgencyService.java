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

    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }

    public Optional<Agency> getAgencyById(Long id) {
        return agencyRepository.findById(id);
    }

    public Agency saveOrUpdateAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    public void deleteAgency(Long id) {
        agencyRepository.deleteById(id);
    }

    public List<Agency> findAll() {
        return agencyRepository.findAll();
    }

    public Agency findById(Long id) {
        return agencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found with id " + id));
    }

    public Agency save(Agency agency) {
        return agencyRepository.save(agency);
    }

    public Agency update(Long id, Agency agencyDetails) {
        Agency agency = agencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found with id " + id));

        agency.setName(agencyDetails.getName());
        agency.setUrl(agencyDetails.getUrl());
        agency.setTimezone(agencyDetails.getTimezone());
        agency.setPhone(agencyDetails.getPhone());
        agency.setLang(agencyDetails.getLang());

        return agencyRepository.save(agency);
    }

    public void delete(Long id) {
        Agency agency = agencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agency not found with id " + id));
        agencyRepository.delete(agency);
    }
}
