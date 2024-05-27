package com.cg.ims.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cg.ims.dto.CustomerDTO;
import com.cg.ims.dto.ProductDTO;
import com.cg.ims.exception.CustomerException;
import com.cg.ims.exception.ProductNotFoundException;
import com.cg.ims.service.ICustomerServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//@Api(tags= "Customer Mangament")
@RestController
@RequestMapping("/inventory")
@CrossOrigin("*")
public class CustomerController {
		@Autowired
		private ICustomerServiceImpl customerService;
		//private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
		 
        @ApiOperation("add a new Customer")
		@PostMapping("/addcustomer")
		 public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO cust) throws CustomerException {
		    	CustomerDTO addCustomer=customerService.addCustomer(cust);
		    	return new ResponseEntity<>(addCustomer, HttpStatus.CREATED);
		    }
        @ApiOperation(" update new Customer")
		 @PutMapping("/updatecustomer")
		 public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO cust)throws CustomerException {
			 CustomerDTO updateCustomer=customerService.updateCustomer(cust);
		    	return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
		    }
		 
        @ApiOperation("get all Customers")
		 @GetMapping("/getallcustomer")
		 public ResponseEntity<List<CustomerDTO>> viewAllCustomer()throws CustomerException{
			 List<CustomerDTO> allCustomers = customerService.viewAllCustomer();
		        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
		 }
          
        @ApiOperation("get Customer byid")
		 @GetMapping("/getcustomerbyid/{id}")
		 public ResponseEntity<CustomerDTO> viewcustomer(@PathVariable("id") int id)throws CustomerException{
			 CustomerDTO customer = customerService.viewCustomer(id);
		        return new ResponseEntity<>(customer, HttpStatus.OK);
			 
	     }
         @ApiOperation("delete a Customer")
		 @DeleteMapping("/deletecustomer/{id}")
		 public ResponseEntity<CustomerDTO> removeCustomer(@PathVariable("id") int id) throws CustomerException{
			  CustomerDTO removedCustomer = customerService.removeCustomer(id);
		        return new ResponseEntity<>(removedCustomer, HttpStatus.OK);
			 
			}
//         @GetMapping("/viewProductById/{id}")
//     	public ResponseEntity<ProductDTO> viewProductById(@PathVariable int id)throws ProductNotFoundException  {
//     		ProductDTO save = customerService.viewProductById(id);
//     		return new ResponseEntity<>(save, HttpStatus.CREATED);
//     	}
//        @GetMapping("/viewAllProducts/")
//     	ResponseEntity<List<ProductDTO>> viewAllProducts() {
//     		List<ProductDTO> p1 = customerService.viewAllProducts();
//     		return new ResponseEntity<>(p1, HttpStatus.CREATED);
//		 
//			}


}
