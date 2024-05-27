package com.cg.ims.service;

import java.util.List;

import com.cg.ims.dto.CategoryDTO;
import com.cg.ims.dto.ProductDTO;
import com.cg.ims.exception.CategoryException;

public interface ICategoryService {
	public CategoryDTO addCategory(CategoryDTO category) throws CategoryException;
	public CategoryDTO updateCategory(CategoryDTO category) throws CategoryException;
	public CategoryDTO deleteCategory(Integer id) throws CategoryException;
	public CategoryDTO getCategoryById(Integer id) throws CategoryException;
	public List<CategoryDTO> getAllCategories();
	List<ProductDTO> getProdctsOfOneCategory(String category)throws CategoryException;
}


