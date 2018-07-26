package org.ccunix.eshop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartModel {
	/**
	 * 购物车id
	 */
	private int id;
	/**
	 * 购物车所属会员编号
	 */
	private int member;
	/**
	 * 总价
	 */
	private double money;
	/**
	 * 购物车状态
	 */
	private int cartStatus;
	/**
	 * 购物车的商品详细信息
	 */
    Map<Integer, CartSelectedmerModel> cartSelectedmerMap = new HashMap<Integer, CartSelectedmerModel>();
	
    public CartModel(){}
    
    public CartModel(int id, int member, double money, int cartStatus) {
		this.id = id;
		this.member = member;
		this.money = money;
		this.cartStatus = cartStatus;
	}

	public CartModel(int id, int member, double money, int cartStatus,
			 Map<Integer, CartSelectedmerModel> cartSelectedmerMap) {
		this.id = id;
		this.member = member;
		this.money = money;
		this.cartStatus = cartStatus;
		this.cartSelectedmerMap = cartSelectedmerMap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(int cartStatus) {
		this.cartStatus = cartStatus;
	}

	public Map<Integer, CartSelectedmerModel> getCartSelectedmerMap() {
		return cartSelectedmerMap;
	}

	public void setCartSelectedmerMap(
			Map<Integer, CartSelectedmerModel> cartSelectedmerMap) {
		this.cartSelectedmerMap = cartSelectedmerMap;
	}

	


    
	
    
}
