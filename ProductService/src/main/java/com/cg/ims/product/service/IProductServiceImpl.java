package com.cg.ims.product.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.ims.product.dto.ProductDTO;
import com.cg.ims.product.exception.ProductException;
import com.cg.ims.product.exception.ProductNotFoundException;

import com.cg.ims.product.repository.IProductRepository;
@Service
public class IProductServiceImpl implements IProductService{

	@Autowired
	private IProductRepository productRepository;
	@Autowired
//	private ICustomerRepository  customerRepository;
//	@Autowired
//	private RestTemplate restTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(IProductServiceImpl.class);
	
	@Override
	public ProductDTO addProduct(ProductDTO product) throws ProductException {
		logger.info("Adding new Products: {}",product);
		if(productRepository.existsById(product.getProductId()))
		{
			throw new ProductException("Product Id already exist");
		}
		else
		{
			productRepository.save(product);
			logger.info("Products added Successfully: {}",product);
			return product;
		}
	}

	@Override
	public ProductDTO updateProduct(ProductDTO product) throws ProductException {
		logger.info("Updating new Products:{}",product);
		if(productRepository.existsById(product.getProductId()))
		{
			productRepository.save(product);
			
		}
		else
		{
			throw new ProductException("product Id doesn't exist");
		}
		logger.info("Products Updated Successfully:{}",product);
		return product;
	}

	@Override
	public ProductDTO deleteProduct(Integer id) throws ProductException
	{
		logger.info("Removing the product:{}",id);
		if(productRepository.existsById(id))
		{
			ProductDTO product=productRepository.findById(id).get();
			if(productRepository.existsById(id))
			{
				productRepository.deleteById(id);
			}
			logger.info("Removed product successfully:{}",id);
			return product;
		}
		else
		{
			throw new ProductException("Product Id not found");
		}
	}

	@Override
	public ProductDTO getProductById(Integer id) throws ProductException 
	{
		logger.info("viewing Product: {}",id);
		if(productRepository.existsById(id))
		{
			return productRepository.findById(id).get();
		}
		else
		{
			logger.info("Product viewed successfully: {}",id);
			throw new ProductException("Product Id not found");
		}
		
	}

	@Override
	public List<ProductDTO> getAllProducts() 
	{
		logger.info("viewing all customers");
		List<ProductDTO> list=productRepository.findAll();
		logger.info("viewed customers successfully");
		return list;
	}

	@Override
	public ProductDTO viewProductById(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	    
	

	}



