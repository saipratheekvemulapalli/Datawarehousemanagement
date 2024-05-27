package com.cg.ims.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ims.dto.CategoryDTO;
import com.cg.ims.dto.ProductDTO;
import com.cg.ims.exception.CategoryException;
import com.cg.ims.service.ICategoryServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//@Api(tags = "Category Management")
@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	ICategoryServiceImpl categoryService;

	 private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	 @ApiOperation("add a new category")
    @PostMapping("/addcategory")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO cat) throws CategoryException {
        CategoryDTO addedCategory = categoryService.addCategory(cat);
        return new ResponseEntity<>(addedCategory, HttpStatus.CREATED);
    }

    //@ApiOperation("update a new category")
	 @PutMapping("/updatecategory")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO cat) throws CategoryException {
        CategoryDTO updatedCategory = categoryService.updateCategory(cat);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    //@ApiOperation("remove a category")
   @DeleteMapping("/removecategory/{id}")
    public ResponseEntity<CategoryDTO> removeCategory(@PathVariable("id") Integer id) throws CategoryException {
        CategoryDTO removedCategory = categoryService.deleteCategory(id);
        return new ResponseEntity<>(removedCategory, HttpStatus.OK);
    }

    //@ApiOperation("view all categories")
    @GetMapping("/viewallcategory")
    public ResponseEntity<List<CategoryDTO>> viewAllCategory() throws CategoryException {
        List<CategoryDTO> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }
    

    //@ApiOperation("view a category by id")
    @GetMapping("/viewcategory/{id}")
    public ResponseEntity<CategoryDTO> viewcategory(@PathVariable("id") Integer id) throws CategoryException {
        CategoryDTO category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
  
    
    @GetMapping("/oneCategoryProducts/{category}")
    public ResponseEntity<List<ProductDTO>> productsOfOneCat(@PathVariable("category") String category) throws CategoryException {
        List<ProductDTO> oneCatProcusts = categoryService.getProdctsOfOneCategory(category);
        return new ResponseEntity<>(oneCatProcusts, HttpStatus.OK);
    }
    
    
//	@GetMapping("/eurekha")
//	public String name() {
//		return "eurekha";
//	}
}
