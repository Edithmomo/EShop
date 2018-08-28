package org.ccunix.eshop.model;


/**
 * 书籍类
 * @author Edith
 *
 */
public class MerchandiseModel {
	/**
	 * 书籍id
	 */
	private int id;
	/**
	 * 书籍目录编号
	 */
	private int category;
	/**
	 * 书籍名
	 */
	private String merName;
	/**
	 * 价格
	 */
	private double price;
	/**
	 * 特价
	 */
	private double sPrice;
	/**
	 * 型号
	 */
	private String merModel;
	/**
	 * 图片地址
	 */
	private String picture;
	/**
	 * 书籍简介
	 */
	private String merDesc;
	/**
	 * 出版社
	 */
	private String manufacturer;
	/**
	 * 出版时间
	 */
	private String leaveFactoryDate;
	/**
	 * 是否为特价
	 */
	private int special;
	/**
	 * 书籍目录名
	 */
	private String cateName;
	private CategoryModel categoryModel;
	public MerchandiseModel(){}
	
	public MerchandiseModel(int id, int category, String merName, double price,
			double sPrice, String merModel, String picture, String merDesc,
			String manufacturer, String leaveFactoryDate, int special) {
		this.id = id;
		this.category = category;
		this.merName = merName;
		this.price = price;
		this.sPrice = sPrice;
		this.merModel = merModel;
		this.picture = picture;
		this.merDesc = merDesc;
		this.manufacturer = manufacturer;
		this.leaveFactoryDate = leaveFactoryDate;
		this.special = special;
	}
    
	public MerchandiseModel(int id, int category, String merName, double price,
			double sPrice, String merModel, String picture, String merDesc,
			String manufacturer, String leaveFactoryDate, int special,
			String cateName) {
		this.id = id;
		this.category = category;
		this.merName = merName;
		this.price = price;
		this.sPrice = sPrice;
		this.merModel = merModel;
		this.picture = picture;
		this.merDesc = merDesc;
		this.manufacturer = manufacturer;
		this.leaveFactoryDate = leaveFactoryDate;
		this.special = special;
		this.cateName = cateName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getsPrice() {
		return sPrice;
	}

	public void setsPrice(double sPrice) {
		this.sPrice = sPrice;
	}

	public String getMerModel() {
		return merModel;
	}

	public void setMerModel(String merModel) {
		this.merModel = merModel;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getMerDesc() {
		return merDesc;
	}

	public void setMerDesc(String merDesc) {
		this.merDesc = merDesc;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getLeaveFactoryDate() {
		return leaveFactoryDate;
	}

	public void setLeaveFactoryDate(String leaveFactoryDate) {
		this.leaveFactoryDate = leaveFactoryDate;
	}

	public int getSpecial() {
		return special;
	}

	public void setSpecial(int special) {
		this.special = special;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	
	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}
	
}
