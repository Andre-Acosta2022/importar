package com.example.demo.daoimpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.DocumentosPlanDao;
import com.example.demo.entity.DocumentosPlan;
import com.example.demo.repository.DocumentosPlanRepository;

@Component
public class DocumentosPlanDaoImpl implements DocumentosPlanDao {

    @Autowired
    private DocumentosPlanRepository documentosPlanRepository;

    @Override
    public DocumentosPlan create(DocumentosPlan a) {
        return documentosPlanRepository.save(a);
    }

    @Override
    public DocumentosPlan update(DocumentosPlan a) {
        return documentosPlanRepository.save(a);
    }

    @Override
    public void delete(Long id) {
        documentosPlanRepository.deleteById(id);
    }

    @Override
    public Optional<DocumentosPlan> read(Long id) {
        return documentosPlanRepository.findById(id);
    }

    @Override
    public List<DocumentosPlan> readAll() {
        return documentosPlanRepository.findAll();
    }
}

