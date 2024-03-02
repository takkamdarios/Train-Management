package com.train.demo.service;

import com.train.demo.model.Transfer;
import com.train.demo.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferService {

    private final TransferRepository transferRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public List<Transfer> findAllTransfers() {
        return transferRepository.findAll();
    }

    public Optional<Transfer> findTransferById(Long id) {
        return transferRepository.findById(id);
    }

    public Transfer saveTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    public void deleteTransfer(Long id) {
        transferRepository.deleteById(id);
    }


    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    public Transfer findById(Long id) {
        return transferRepository.findById(id).orElseThrow(() -> new RuntimeException("Transfer not found"));
    }

    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    public Transfer update(Long id, Transfer transfer) {
        // Ensure the entity exists before updating
        Transfer existingTransfer = findById(id);
        // Update fields here
        return save(existingTransfer);
    }

    public void delete(Long id) {
        transferRepository.deleteById(id);
    }
    // Additional methods to handle business logic related to transfers
    // For example, finding transfers by fromStopId or toStopId, handling transfer types, etc.

}
