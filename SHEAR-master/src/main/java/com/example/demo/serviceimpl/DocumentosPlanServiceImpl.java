package com.example.demo.serviceimpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DocumentosPlanDao;
import com.example.demo.entity.DocumentosPlan;
import com.example.demo.service.DocumentosPlanService;

@Service
public class DocumentosPlanServiceImpl implements DocumentosPlanService {

    @Autowired
    private DocumentosPlanDao documentosPlanDao;

    @Override
    public DocumentosPlan create(DocumentosPlan a) {
        return documentosPlanDao.create(a);
    }

    @Override
    public DocumentosPlan update(DocumentosPlan a) {
        return documentosPlanDao.update(a);
    }

    @Override
    public void delete(Long id) {
        documentosPlanDao.delete(id);
    }

    @Override
    public Optional<DocumentosPlan> read(Long id) {
        return documentosPlanDao.read(id);
    }

    @Override
    public List<DocumentosPlan> readAll() {
        return documentosPlanDao.readAll();
    }
}
