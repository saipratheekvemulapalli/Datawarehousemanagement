//package com.cg.ims.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cg.ims.dto.ProductDTO;
//import com.cg.ims.exception.ProductException;
//import com.cg.ims.repository.IProductRepository;
//
//@Service
//public class ProductServiceImpl implements IProductService{
//	@Autowired
//	private IProductRepository productRepository;
//	
//	@Override
//	public ProductDTO addProduct(ProductDTO product) throws ProductException {
//		if(productRepository.existsById(product.getProductId()))
//		{
//			throw new ProductException("Product Id already exist");
//		}
//		else
//		{
//			productRepository.save(product);
//			return product;
//		}
//	}
//
//	@Override
//	public ProductDTO updateProduct(ProductDTO product) throws ProductException {
//		if(productRepository.existsById(product.getProductId()))
//		{
//			productRepository.save(product);
//			return product;
//		}
//		else
//		{
//			throw new ProductException("product Id doesn't exist");
//		}
//	}
//
//	@Override
//	public ProductDTO deleteProduct(Integer id) throws ProductException
//	{
//		if(productRepository.existsById(id))
//		{
//			ProductDTO product=productRepository.findById(id).get();
//			productRepository.deleteById(id);
//			return product;
//		}
//		else
//		{
//			throw new ProductException("Product Id not found");
//		}
//	}
//
//	@Override
//	public ProductDTO getProductById(Integer id) throws ProductException 
//	{
//		if(productRepository.existsById(id))
//		{
//			return productRepository.findById(id).get();
//		}
//		else
//		{
//			throw new ProductException("Product Id not found");
//		}
//		
//	}
//
//	@Override
//	public List<ProductDTO> getAllProducts() 
//	{
//		List<ProductDTO> list=productRepository.findAll();
//		return list;
//	}
//
//
//}
