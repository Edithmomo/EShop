package org.ccunix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.ccunix.eshop.model.CartSelectedmerModel;
import org.ccunix.eshop.util.DBManager;

public class CartSelectedmerDAO {
	CartDAO cartDAO = new CartDAO();
	/**
	 * 获取购物车中的商品信息 
	 * @param cartId 购物车id
	 * @return 商品集合
	 */
	public Map<Integer, CartSelectedmerModel> getCartSelectedmerMap1(int cartId) {
		Map<Integer, CartSelectedmerModel> cartSelectedmerMap = new HashMap<Integer, CartSelectedmerModel>();
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select cs.ID id,cs.Cart cart,cs.Merchandise merchandise,cs.Number number,cs.Price cartSelectedMerPrice,"
				+ "cs.Money cartSelectedMermoney,m.MerName mername,m.Price merPrice,m.SPrice merSprice,m.Category category"
				+ " from cartselectedmer cs, merchandise m "
				+ " where cs.Merchandise = m.ID and cs.Cart = ?";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cartId);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				int i = 0;
				CartSelectedmerModel cartSelectedmerModel = new CartSelectedmerModel(
						set.getInt(++i), set.getInt(++i), set.getInt(++i),
						set.getInt(++i), set.getDouble(++i),
						set.getDouble(++i), set.getString(++i),
						set.getDouble(++i), set.getDouble(++i), set.getInt(++i));
                cartSelectedmerMap.put(cartSelectedmerModel.getMerchandise(), cartSelectedmerModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}

		return cartSelectedmerMap;
	}
	/**
	 * 添加商品
	 * @param cartId 购物车id
	 * @param merId 商品id
	 * @param price 商品价格
	 * @return 成功 或失败
	 */
	public boolean addCartSelectedmer(int cartId,int merId,double price) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "insert into cartselectedmer (Cart,Merchandise,Number,Price,Money) values(?,?,1,?,?)";
		try {
			connection = DBManager.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cartId);
			ps.setInt(2, merId);
			ps.setDouble(3, price);
			ps.setDouble(4, price);
			int row = ps.executeUpdate();
			boolean b = cartDAO.updateCart(connection, cartId);
			if(row>0 && b){
				connection.commit();
				return true;
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return false;
	}
	/**
	 * 更新购物车中商品的数量
	 * @param cartId 购物车id
	 * @param merId   商品id
	 * @param number 添加数量
	 * @return 成功（true) 或     失败(false)
	 */
	public boolean updateCartSelectedmer(int cartId,int merId,int number,int type) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "";
		if(type == 1){
			sql = "update cartselectedmer set number=number+?, money = money + price*? where cart = ? and Merchandise = ?";
		}else{
			sql = "update cartselectedmer set number=?, money = price*? where cart = ? and id = ?";
		}
		try {
			connection = DBManager.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, number);
			ps.setInt(2, number);
			ps.setInt(3, cartId);
			ps.setInt(4, merId);
			int row = ps.executeUpdate();
			boolean b = cartDAO.updateCart(connection, cartId);
			if(row>0 && b){
				connection.commit();
				return true;
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return false;
	}
	
	/**
	 * 删除购物车中的一条商品信息
	 * @param merId 商品id
	 * @param cartId 购物车id
	 * @return 成功或失败
	 */
	public boolean deleteOneCartSelectedmer(int merId,int cartId) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "delete from cartselectedmer where cart = ?";
		try {
			connection = DBManager.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, merId);
			int row = ps.executeUpdate();
			boolean b = cartDAO.updateCart(connection, cartId);
			if(row>0 && b){
				connection.commit();
				return true;
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return false;
	}
	
	/**
	 * 删除购物车中所以的商品
	 * @param cartId 购物车id
	 * @return 成功或失败
	 */
	public boolean deleteAllCartSelectedmer(int cartId) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "delete from cartselectedmer where cart = ?";
		try {
			connection = DBManager.getConnection();
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cartId);
			int row = ps.executeUpdate();
			boolean b = cartDAO.updateCart(connection, cartId);
			if(row>0 && b){
				connection.commit();
				return true;
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new CartSelectedmerDAO().deleteAllCartSelectedmer(24));
	}
}
