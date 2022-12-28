package com.api.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.entity.Product;
import com.api.entity.ProductPDFExporter;
import com.api.helper.Helper;
import com.api.service.ProductService;
import com.itextpdf.text.DocumentException;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String Pdf(Model model) {
    	
    	Product product = new Product();
    	model.addAttribute("product", product);
    	return "ExcelToPdf";
    }
    
    
    @PostMapping("/product/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            //true

            this.productService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/products/export")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
       
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=products_" + ".pdf";
        
        response.setHeader(headerKey, headerValue);
        
        List<Product> listProduts = productService.getAllProducts();
        
        ProductPDFExporter exporter = new ProductPDFExporter(listProduts);
        exporter.export(response);
            
    }
    
    

	
}
