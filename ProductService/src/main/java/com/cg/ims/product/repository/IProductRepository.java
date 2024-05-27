package com.cg.ims.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ims.product.dto.ProductDTO;



public interface IProductRepository extends JpaRepository<ProductDTO,Integer>{

}
