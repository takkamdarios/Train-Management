package com.train_management.train_management.service;

import com.train_management.train_management.model.Translation;
import com.train_management.train_management.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranslationService {

    private final TranslationRepository translationRepository;

    @Autowired
    public TranslationService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    // Method to get translations based on table name, column name, and language
    public List<Translation> getTranslations(String tableName, String columnName, String language) {
        return translationRepository.findByTableNameAndColumnNameAndLanguage(tableName, columnName, language);
    }

    // Method to add or update a translation
    public Translation saveOrUpdateTranslation(Translation translation) {
        return translationRepository.save(translation);
    }

    // Method to find a translation by ID
    public Optional<Translation> findTranslationById(Long id) {
        return translationRepository.findById(id);
    }

    // Method to delete a translation by ID
    public void deleteTranslationById(Long id) {
        translationRepository.deleteById(id);
    }


    public List<Translation> findAll() {
        return translationRepository.findAll();
    }

    public Translation findById(Long id) {
        return translationRepository.findById(id).orElseThrow(() -> new RuntimeException("Translation not found"));
    }

    public Translation save(Translation translation) {
        return translationRepository.save(translation);
    }

    public Translation update(Long id, Translation translation) {
        // Ensure the entity exists before updating
        Translation existingTranslation = findById(id);
        // Update fields here
        return save(existingTranslation);
    }

    public void delete(Long id) {
        translationRepository.deleteById(id);
    }
}
