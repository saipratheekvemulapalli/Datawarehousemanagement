package com.cg.ims.service;

import java.util.List;

import com.cg.ims.dto.CustomerDTO;
import com.cg.ims.dto.ProductDTO;
import com.cg.ims.exception.CustomerException;

public interface ICustomerService {
	CustomerDTO addCustomer(CustomerDTO cust)throws CustomerException;
	CustomerDTO updateCustomer(CustomerDTO cust)throws CustomerException;
	CustomerDTO removeCustomer(int id) throws CustomerException;
	CustomerDTO viewCustomer(int id) throws CustomerException;
	List<CustomerDTO> viewAllCustomer();
//	public ProductDTO viewProductById(int id);
//	public List<ProductDTO> viewAllProducts();


}
