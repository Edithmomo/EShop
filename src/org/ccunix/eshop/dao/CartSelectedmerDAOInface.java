package org.ccunix.eshop.dao;

import java.util.Map;
import org.ccunix.eshop.model.CartSelectedmerModel;

public interface CartSelectedmerDAOInface {
	/**
	 * 获取购物车中的商品信息 
	 * @param cartId 购物车id
	 * @return 商品集合
	 */
	public Map<Integer, CartSelectedmerModel> getCartSelectedmerMap(int cartId);
	/**
	 * 添加商品
	 * @param cartId 购物车id
	 * @param merId 商品id
	 * @param price 商品价格
	 * @return 成功 或失败
	 */
	public boolean addCartSelectedmer(int cartId,int merId,double price);
	/**
	 * 更新购物车中商品的数量
	 * @param cartId 购物车id
	 * @param merId   商品id
	 * @param number 添加数量
	 * @return 成功（true) 或     失败(false)
	 */
	public boolean updateCartSelectedmer(int cartId,int merId,int number,int type);
	
	/**
	 * 删除购物车中的一条商品信息
	 * @param merId 商品id
	 * @param cartId 购物车id
	 * @return 成功或失败
	 */
	public boolean deleteOneCartSelectedmer(int merId,int cartId);
	
	/**
	 * 删除购物车中所以的商品
	 * @param cartId 购物车id
	 * @return 成功或失败
	 */
	public boolean deleteAllCartSelectedmer(int cartId);
	
}
