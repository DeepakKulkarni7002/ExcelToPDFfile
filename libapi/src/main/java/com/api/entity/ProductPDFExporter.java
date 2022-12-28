package com.api.entity;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class ProductPDFExporter {
   
	  private List<Product> listProducts;

	public ProductPDFExporter(List<Product> listProducts) {
		this.listProducts = listProducts;
	}
	  
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		
		cell.setPhrase(new Phrase("productID"));
		
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("productName"));
		
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("productMrp"));
		
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("productPrice"));
		
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("productSaveRs"));
	
		table.addCell(cell);
	}
	
    private void writeTableData(PdfPTable table) {
    	
    	for(Product product : listProducts) {
    		
    		
    		
    		table.addCell(String.valueOf(product.getProductId()));	
    		table.addCell(String.valueOf(product.getProductName()));
    		table.addCell(String.valueOf(product.getProductMrp()));
    		table.addCell(String.valueOf(product.getProductPrice()));
    		table.addCell(String.valueOf(product.getProductSaveRs()));
    		
    		
    		}
    	
    	
    	}
		
    
	
    public void export(HttpServletResponse response) throws DocumentException, IOException {
    	
    	Document document = new Document(PageSize.A4);
    	
    	PdfWriter.getInstance(document, response.getOutputStream());
    	
    	document.open();
  
    	document.add(new Paragraph("List of products"));
    	
    	PdfPTable table = new PdfPTable(5);
    	table.setWidthPercentage(100);
    	    	
    	
    	writeTableHeader(table);
    	writeTableData(table);
    	
    	document.add(table);
    	
    	document.close();
    	
    }

	
}
