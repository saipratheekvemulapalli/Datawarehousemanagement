package com.cg.ims.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cg.ims.dto.CategoryDTO;
import com.cg.ims.dto.ProductDTO;
import com.cg.ims.exception.CategoryException;
import com.cg.ims.repository.ICategoryRepository;



@Service
public class ICategoryServiceImpl implements ICategoryService {
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private RestTemplate restTemplate;

//	@Override
//	public CategoryDTO addCategory(CategoryDTO category) throws CategoryException
//	{
//		if(categoryRepository.existsById(category.getCatId()))
//		{
//			throw new CategoryException("Category Id already exist");
//		}
//		else
//		{
//			categoryRepository.save(category);
//			return category;
//		}
//	}
	
	@Override
	public CategoryDTO addCategory(CategoryDTO category) throws CategoryException {
	    Optional<CategoryDTO> existingCategory = categoryRepository.findById(category.getCatId());

	    if (existingCategory.isPresent()) {
	        throw new CategoryException("Category Id already exists");
	    } else {
	        categoryRepository.save(category);
	        return category;
	    }
	}

//	@Override
//	public CategoryDTO updateCategory(CategoryDTO category) throws CategoryException
//	{
//		if(categoryRepository.existsById(category.getCatId()))
//		{
//			categoryRepository.save(category);
//			return category;
//		}
//		else
//		{
//			throw new CategoryException("Category Id not found");
//		}
//	}
	
	
	@Override
	public CategoryDTO updateCategory(CategoryDTO category) throws CategoryException {
	    Integer categoryId = category.getCatId();
	    Optional<CategoryDTO> existingCategory = categoryRepository.findById(category.getCatId());
	    CategoryDTO repCategoryDTO= existingCategory.orElseThrow(()-> new CategoryException("Category Id not found"));
	    categoryRepository.save(category);
		return category;
	}

//	@Override
//	public CategoryDTO deleteCategory(Integer id) throws CategoryException {
//		if(categoryRepository.existsById(id))
//		{
//			CategoryDTO category=categoryRepository.findById(id).get();
//			categoryRepository.delete(category);
//			return category;
//		}
//		else
//		{
//			throw new CategoryException("Category Id not found");
//		}
//	}
	
	
	@Override
	public CategoryDTO deleteCategory(Integer id) throws CategoryException {
	    Optional<CategoryDTO> existingCategory = categoryRepository.findById(id);
	    CategoryDTO repCategoryDTO= existingCategory.orElseThrow(()-> new CategoryException("Category Id not found"));
	    categoryRepository.delete(repCategoryDTO);
	    return repCategoryDTO;
	    
	}
	

//	@Override
//	public CategoryDTO getCategoryById(Integer id) throws CategoryException {
//		if(categoryRepository.existsById(id))
//		{
//			return categoryRepository.findById(id).get();
//		}
//		else
//		{
//			throw new CategoryException("Category Id not found");
//		}
//	}

	
	@Override
	public CategoryDTO getCategoryById(Integer id) throws CategoryException {
	    Optional<CategoryDTO> existingCategory = categoryRepository.findById(id);
	    return existingCategory.orElseThrow(() -> new CategoryException("Category Id not found"));
	}
	
	
	@Override
	public List<CategoryDTO> getAllCategories() {
		List<CategoryDTO> list=categoryRepository.findAll();
		return list;
		
	}
	
	
	@Override
	public List<ProductDTO>getProdctsOfOneCategory(String category)throws CategoryException{
		 try {
		        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(
		            "http://localhost:8000/Product/ims/getallproducts",
		            HttpMethod.GET,
		            null,
		            new ParameterizedTypeReference<List<ProductDTO>>() {}
		        );

		        List<ProductDTO> allProducts = response.getBody();
		        
		        if (allProducts == null) {
		            throw new CategoryException("Failed to retrieve products from the server");
		        }

		        List<ProductDTO> productOfSameCat = allProducts.stream()
		                .filter(e -> e.getCategory().equals(category))
		                .collect(Collectors.toList());

		        return productOfSameCat;
		    } catch (RestClientException e) {
		        throw new CategoryException( e.getMessage());
		    }
		 
		 
	}

}

