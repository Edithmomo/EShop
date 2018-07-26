package org.ccunix.eshop.model;

public class CategoryModel {
	/**
	 * 目录id
	 */
	private int id;
	/**
	 * 目录名
	 */
	private String cateName;
	/**
	 * 目录描述
	 */
	private String cateDesc;

	public CategoryModel() {
	}

	public CategoryModel(int id, String cateName, String cateDesc) {
		this.id = id;
		this.cateName = cateName;
		this.cateDesc = cateDesc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateDesc() {
		return cateDesc;
	}

	public void setCateDesc(String cateDesc) {
		this.cateDesc = cateDesc;
	}

}
