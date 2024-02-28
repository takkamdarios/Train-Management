package com.train_management.train_management.service;

import com.train_management.train_management.model.Transfer;
import com.train_management.train_management.repository.TransferRepository;
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

    // Additional methods to handle business logic related to transfers
    // For example, finding transfers by fromStopId or toStopId, handling transfer types, etc.

}
