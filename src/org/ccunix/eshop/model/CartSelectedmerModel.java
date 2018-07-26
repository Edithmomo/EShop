package org.ccunix.eshop.model;

public class CartSelectedmerModel {
	/**
	 * 购物车中商品的id
	 */
	private int id;
	/**
	 * 购物车的id
	 */
	private int cart;
	/**
	 * 商品id
	 */
	private int merchandise;
	/**
	 * 商品数量
	 */
	private int number;
	/**
	 * 商品实际交易价格
	 */
	private double cartSelectedMerPrice;
	/**
	 * 交易总价
	 */
	private double cartSelectedMerMoney;
	/**
	 * 商品名称
	 */
	private String merName;
	/**
	 * 商品市场价格
	 */
	private double merPrice;
	/**
	 * 特价
	 */
	private double merSprice;
	/**
	 * 商品类型主键
	 */
	private double categroy;
	
	public CartSelectedmerModel(){}

	public CartSelectedmerModel(int id, int cart, int merchandise, int number,
			double cartSelectedMerPrice, double cartSelectedMerMoney,
			String merName, double merPrice, double merSprice, double categroy) {
		this.id = id;
		this.cart = cart;
		this.merchandise = merchandise;
		this.number = number;
		this.cartSelectedMerPrice = cartSelectedMerPrice;
		this.cartSelectedMerMoney = cartSelectedMerMoney;
		this.merName = merName;
		this.merPrice = merPrice;
		this.merSprice = merSprice;
		this.categroy = categroy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
	}

	public int getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(int merchandise) {
		this.merchandise = merchandise;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getCartSelectedMerPrice() {
		return cartSelectedMerPrice;
	}

	public void setCartSelectedMerPrice(double cartSelectedMerPrice) {
		this.cartSelectedMerPrice = cartSelectedMerPrice;
	}

	public double getCartSelectedMerMoney() {
		return cartSelectedMerMoney;
	}

	public void setCartSelectedMerMoney(double cartSelectedMerMoney) {
		this.cartSelectedMerMoney = cartSelectedMerMoney;
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	public double getMerPrice() {
		return merPrice;
	}

	public void setMerPrice(double merPrice) {
		this.merPrice = merPrice;
	}

	public double getMerSprice() {
		return merSprice;
	}

	public void setMerSprice(double merSprice) {
		this.merSprice = merSprice;
	}

	public double getCategroy() {
		return categroy;
	}

	public void setCategroy(double categroy) {
		this.categroy = categroy;
	}
	
	
}
