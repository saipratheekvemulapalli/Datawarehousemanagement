package com.cg.ims;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.cg.ims.product.dto.ProductDTO;

import com.cg.ims.product.exception.ProductException;

import com.cg.ims.product.repository.IProductRepository;

import com.cg.ims.product.service.IProductServiceImpl;

@SpringBootTest

class ProductServiceApplicationTests {

//	@Test

//	void contextLoads() {

//	}

	@Mock

	IProductServiceImpl productserviceimpl;

	@Mock

	IProductRepository productrepository;

	@Test

	public void testProductById() throws ProductException {

		ProductDTO p = new ProductDTO();

		when(productserviceimpl.getProductById(1)).thenReturn(p).thenThrow(ProductException.class);

		assertNotNull(p);

	}

	@Test

	public void testInvalidProductById() throws ProductException {

		ProductDTO p = new ProductDTO();

		when(productserviceimpl.getProductById(1)).thenReturn(p).thenThrow(ProductException.class);

		assertThatExceptionOfType(ProductException.class);

	}

	@Test

	public void testgetAllProduct() {

		List<ProductDTO> allproducts1 = new ArrayList<>();

		allproducts1.add(new ProductDTO());

		allproducts1.add(new ProductDTO());

		when(productserviceimpl.getAllProducts()).thenReturn(allproducts1);

		assertEquals(2, allproducts1.size());

		assertThat(allproducts1.size()).isGreaterThan(0);

	}

	// Testing for update the Product

	@Test

	public void testupdateProduct() throws ProductException {

		ProductDTO product = new ProductDTO();

		product.setProductId(1);

		product.setProductName("fan");

		product.setPrice(15);

		product.setQuantity(10);

		product.setSpecification("small");

		when(productserviceimpl.updateProduct(product)).thenReturn(product);

		assertNotNull(productserviceimpl.updateProduct(product));

	}

	// Testing for inserting the Product

//            @Test

//

//            public void testInsertProduct() throws ProductException  {

//

//                ProductDTO product =  new ProductDTO();

//

//                product.setProductId(1);

//

//                product.setName("T-Shirt");

//

//                product.setCharges(10.5f);

//

//                product.setQuantity(20L);

//

//                product.setSize("small");

//

//                

//

//                

//

//                when(productserviceimpl.addProduct(product)).thenReturn(product);

//

//                assertEquals("T-Shirts", productserviceimpl.addProduct(product).getName());

//

//                    

//

//            }

	@Test

	public void testProductById1() throws ProductException {

		ProductDTO p = new ProductDTO();

		when(productserviceimpl.deleteProduct(1)).thenReturn(p).thenThrow(ProductException.class);

	}

}
