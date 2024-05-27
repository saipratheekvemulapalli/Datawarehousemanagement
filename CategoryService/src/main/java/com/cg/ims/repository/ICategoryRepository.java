package com.cg.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ims.dto.CategoryDTO;

public interface ICategoryRepository extends JpaRepository<CategoryDTO,Integer>{
 

}
