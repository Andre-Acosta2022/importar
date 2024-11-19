package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.DocumentosPlan;

public interface DocumentosPlanDao {
	DocumentosPlan create(DocumentosPlan a);
    DocumentosPlan update(DocumentosPlan a);
    void delete(Long id);
    Optional<DocumentosPlan> read(Long id);
    List<DocumentosPlan> readAll();
}
