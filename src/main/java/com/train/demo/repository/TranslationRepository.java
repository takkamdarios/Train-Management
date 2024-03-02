package com.train.demo.repository;

import com.train.demo.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long> {

    // Find translations by table name, column name, and language
    List<Translation> findByTableNameAndColumnNameAndLanguage(String tableName, String columnName, String language);
}
