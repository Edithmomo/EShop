package org.ccunix.eshop.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.ccunix.eshop.model.CartModel;
import org.hibernate.Session;

public interface CartDAOIface {
	/**
	 * 是否存在未提交的购物车
	 * @param member 会员id
	 * @return 存在-返回购物车  不存在-返回null
	 */
	public CartModel isExistCart(int member);
	/**
	 * 添加购物车
	 * @param member 会员id
	 * @return 购物车
	 */
	public CartModel addCart(int member);
	/**
	 * 更新购物车的商品总价格
	 * @param connection 链接
	 * @param cartId 购物车id
	 * @return 成功或失败
	 * @throws SQLException
	 */
	public boolean updateCart(Session session ,int cartId);
	public boolean updateCart(Connection connection,int cartId) throws SQLException;
	
	public boolean updateCart(Session session, int cartId,int i);

}
