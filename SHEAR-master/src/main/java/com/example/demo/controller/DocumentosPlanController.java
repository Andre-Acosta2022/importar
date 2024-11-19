package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import com.example.demo.entity.DocumentosPlan;
import com.example.demo.service.DocumentosPlanService;

@RestController
@RequestMapping("/api/documentosplan")
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentosPlanController {

    @Autowired
    private DocumentosPlanService service;

    @GetMapping
    public ResponseEntity<List<DocumentosPlan>> readAlls() {
        try {
            List<DocumentosPlan> lista = service.readAll();
            if (lista.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(lista, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<DocumentosPlan> create(@Valid @RequestBody DocumentosPlan obj) {
        try {
            DocumentosPlan objeto = service.create(obj);
            return new ResponseEntity<>(objeto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentosPlan> getPlanId(@PathVariable Long id) {
        try {
            DocumentosPlan objeto = service.read(id).orElse(null);
            if (objeto != null) {
                return new ResponseEntity<>(objeto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delPlan(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentosPlan> updatePlan(@PathVariable Long id, @Valid @RequestBody DocumentosPlan obj) {
        Optional<DocumentosPlan> objeto = service.read(id);
        if (objeto.isPresent()) {
            DocumentosPlan actualizado = service.update(obj);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
