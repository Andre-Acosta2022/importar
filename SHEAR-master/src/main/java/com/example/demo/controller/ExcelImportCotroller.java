
package com.example.demo.controller;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.ExcelImportService;

@RestController
@RequestMapping("/api/import")
public class ExcelImportCotroller {

    @Autowired
    private ExcelImportService excelImportService;

    @PostMapping("/upload")
    public ResponseEntity<String> importarExcel(@RequestParam("file") MultipartFile file) {
        try {
            File tempFile = File.createTempFile("temp", file.getOriginalFilename());
            file.transferTo(tempFile);

            excelImportService.importarExcel(tempFile);
            return ResponseEntity.ok("Importación exitosa");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al procesar el archivo");
        }
    }
}
