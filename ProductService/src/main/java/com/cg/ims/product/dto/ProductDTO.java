package com.cg.ims.product.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

 

@Entity
@Table(name="ProductTable")
public class ProductDTO {
	@Id
	@Column(name="pid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int productId;

	@Column(name="productname")
	String productName;

	@Column(name="price")
	double price;

	@Column(name="specification")
	String specification;


 

	@Column(name="quantity")
	int quantity;

//	@OneToOne(cascade=CascadeType.PERSIST)
//	@JoinColumn(name="catid")
//	CategoryDto category;

	@Column(name="category")
	String category;

 

	public ProductDTO() {
		super();
	}

 

	public ProductDTO( int productId,
			String productName, double price,
			String color,
			String dimension,
			 String specification,
			 String manufacturer,
			 int quantity, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.specification = specification;
		this.quantity = quantity;
		this.category= category;
	}

 

	public int getProductId() {
		return productId;
	}

 

	public void setProductId(int productId) {
		this.productId = productId;
	}

 

	public String getProductName() {
		return productName;
	}

 

	public void setProductName(String productName) {
		this.productName = productName;
	}

 

	public double getPrice() {
		return price;
	}

 

	public void setPrice(double price) {
		this.price = price;
	}

 

	public String getSpecification() {
		return specification;
	}

 

	public void setSpecification(String specification) {
		this.specification = specification;
	}

 

	public int getQuantity() {
		return quantity;
	}

 

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

 

 

	public String getCategory() {
		return category;
	}

 

	public void setCategory(String category) {
		this.category = category;
	}

 

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", price=" + price + ", specification=" + specification + " quantity=" + quantity + ", category=" + category + "]";
	}

}

 