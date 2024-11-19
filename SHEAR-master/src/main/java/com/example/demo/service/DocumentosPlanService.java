package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.DocumentosPlan;

public interface DocumentosPlanService {
    DocumentosPlan create(DocumentosPlan a);
    DocumentosPlan update(DocumentosPlan a);
    void delete(Long id);
    Optional<DocumentosPlan> read(Long id);
    List<DocumentosPlan> readAll();
}

