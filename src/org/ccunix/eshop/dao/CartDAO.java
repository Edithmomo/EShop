package org.ccunix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.ccunix.eshop.model.CartModel;
import org.ccunix.eshop.util.DBManager;

public class CartDAO {
	/**
	 * 是否存在未提交的购物车
	 * @param member 会员id
	 * @return 存在-返回购物车  不存在-返回null
	 */
	public CartModel isExistCart(int member){
		CartModel cartModel = null;
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select ID,Member,Money,CartStatus from cart where CartStatus = 0 and Member = ?";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1,member);
			ResultSet set = ps.executeQuery();
			if(set.next()){
				int i = 0;
				cartModel = new CartModel(set.getInt(++i), set.getInt(++i), set.getDouble(++i), set.getInt(++i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(connection, ps);
		}
		return cartModel;
	}
	/**
	 * 添加购物车
	 * @param member 会员id
	 * @return 购物车
	 */
	public CartModel addCart(int member){
		CartModel cartModel = null;
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "insert into cart(Member,Money,CartStatus) values (?,0,0)";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1,member);
			int row = ps.executeUpdate();
			if(row > 0){
				String selectSql = "select ID,Member,Money,CartStatus from cart where CartStatus = 0 and Member = ?";
				ps = connection.prepareStatement(selectSql);
				ps.setInt(1,member);
				ResultSet set = ps.executeQuery();
				if(set.next()){
					int i = 0;
					cartModel = new CartModel(set.getInt(++i), set.getInt(++i), set.getDouble(++i), set.getInt(++i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(connection, ps);
		}
		return cartModel;
	}
	
	public boolean updateCart(Connection connection,int cartId) throws SQLException{
		CartModel cartModel = null;
		PreparedStatement ps = null;
		String sql = "update  cart set Money=(select sum(money) from cartselectedmer where cart=?) where id=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1,cartId);
			ps.setInt(2,cartId);
			int row = ps.executeUpdate();
			if(row>0){
				return true;
			}
		return false;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new CartDAO().addCart(19).getId());
	}

}
