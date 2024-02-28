package com.train_management.train_management.controller;

import com.train_management.train_management.model.Translation;
import com.train_management.train_management.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translations")
public class TranslationController {

    private final TranslationService translationService;

    @Autowired
    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping
    public ResponseEntity<List<Translation>> getAllTranslations() {
        return ResponseEntity.ok(translationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Translation> getTranslationById(@PathVariable Long id) {
        return ResponseEntity.ok(translationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Translation> createTranslation(@RequestBody Translation translation) {
        return ResponseEntity.ok(translationService.save(translation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Translation> updateTranslation(@PathVariable Long id, @RequestBody Translation translation) {
        return ResponseEntity.ok(translationService.update(id, translation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        translationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
