package com.cg.ims.product.dto;

public class CategoryDTO {

	private int catId;
	private String catName;
	
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	@Override
	public String toString() {
		return "CategoryDTO [catId=" + catId + ", catName=" + catName + "]";
	}
}
