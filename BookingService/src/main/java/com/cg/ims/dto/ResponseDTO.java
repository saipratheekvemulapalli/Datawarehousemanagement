package com.cg.ims.dto;

public class ResponseDTO {
	private ProductDTO product;
	private CustomerDTO customer;

	public ResponseDTO() {
	}

	public ResponseDTO(ProductDTO product, CustomerDTO customer) {
		this.product = product;
		this.customer = customer;
	}
	

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

}

