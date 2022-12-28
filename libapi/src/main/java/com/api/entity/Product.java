package com.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private Integer productId;

    private String productName;

    private Double productMrp;

    private Double productPrice;
    
    private Double productSaveRs;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer productId, String productName, Double productMrp, Double productPrice,
			Double productSaveRs) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productMrp = productMrp;
		this.productPrice = productPrice;
		this.productSaveRs = productSaveRs;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductMrp() {
		return productMrp;
	}

	public void setProductMrp(Double productMrp) {
		this.productMrp = productMrp;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getProductSaveRs() {
		return productSaveRs;
	}

	public void setProductSaveRs(Double productSaveRs) {
		this.productSaveRs = productSaveRs;
	}

    
}
