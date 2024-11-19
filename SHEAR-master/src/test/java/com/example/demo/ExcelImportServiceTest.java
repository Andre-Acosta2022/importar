package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ExcelImportService;

import java.io.File;

@SpringBootTest
public class ExcelImportServiceTest {
	   @Autowired
	    private ExcelImportService excelImportService;

	    @Test
	    public void testImportarExcel() {
	        try {
	            File excelFile = new File("C:\\Users\\alum.l6\\Documents/data personas.xlsx");
	            excelImportService.importarExcel(excelFile);
	            System.out.println("Importación completada exitosamente.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
