package com.cg.ims;

import static org.mockito.Mockito.when;
import org.mockito.Mock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ims.dto.CategoryDTO;
import com.cg.ims.exception.CategoryException;
import com.cg.ims.repository.ICategoryRepository;
import com.cg.ims.service.ICategoryServiceImpl;

@SpringBootTest
class CategoryServiceApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@Mock

    ICategoryRepository categoryRepository;

    @Mock

    ICategoryServiceImpl categoryService;

    @Test            

    public void testRemoveAllproducts() throws CategoryException {

        CategoryDTO category=new CategoryDTO();



        when(categoryService.deleteCategory(1)).thenReturn(category).thenThrow (CategoryException.class);

        

    }

    @Test public void testViewAll() throws CategoryException {

        CategoryDTO category=new CategoryDTO();

        when(categoryService.getCategoryById(1)).thenReturn(category).thenThrow(CategoryException.class);

    }

}
