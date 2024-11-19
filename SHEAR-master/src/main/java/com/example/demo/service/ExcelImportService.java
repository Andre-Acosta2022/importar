package com.example.demo.service;

import java.io.InputStream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ExcelImportService {

    private static final Logger logger = LoggerFactory.getLogger(ExcelImportService.class);

    @Autowired
    private PersonaRepository personaRepository;

    @Transactional
    public void importarExcel(File excelFile) throws Exception {
        try (FileInputStream fis = new FileInputStream(excelFile);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Procesar la primera hoja
            List<Persona> personas = new ArrayList<>();

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Saltar la cabecera

                try {
                    // Validación de datos
                    if (row.getCell(0) == null || row.getCell(0).getStringCellValue().isEmpty()) {
                        throw new IllegalArgumentException("El campo 'nombre' no puede estar vacío en la fila " + row.getRowNum());
                    }

                    // Crear objeto Persona
                    Persona persona = new Persona();
                    persona.setNombre(row.getCell(0).getStringCellValue());
                    persona.setApellido(row.getCell(1).getStringCellValue());
                    persona.setEmail(row.getCell(2).getStringCellValue());
                    persona.setTelefono(row.getCell(3).getStringCellValue());
                    persona.setCodigo(row.getCell(4).getStringCellValue());
                    persona.setDni(row.getCell(5).getStringCellValue());

                    personas.add(persona);
                    logger.info("Fila procesada exitosamente: {}", row.getRowNum());

                } catch (Exception e) {
                    logger.error("Error al procesar la fila: {}. Detalle: {}", row.getRowNum(), e.getMessage());
                }
            }

            // Guardar en la base de datos
            personaRepository.saveAll(personas);
            logger.info("Importación completada exitosamente. Total filas procesadas: {}", personas.size());
        }
    }
}
