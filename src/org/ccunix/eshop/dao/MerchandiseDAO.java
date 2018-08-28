package org.ccunix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ccunix.eshop.model.MerchandiseModel;
import org.ccunix.eshop.util.DBManager;
/**
 * 书籍数据库操作类
 * @author Edith
 *
 */
public class MerchandiseDAO implements MerchandiseDAOIface{
	/**
	 * 查询所以的书籍信息
	 * @return  书籍集合
	 */
	public List<MerchandiseModel> getMerchandiseList() {
		ArrayList<MerchandiseModel> list = new ArrayList<MerchandiseModel>();
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select id,category,merName,price,sPrice,merModel,picture,merDesc,manufacturer,leaveFactoryDate,Special from Merchandise";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				MerchandiseModel merchandiseModel = new MerchandiseModel(
						set.getInt("id"), set.getInt("category"),
						set.getString("merName"), set.getDouble("price"),
						set.getDouble("sPrice"), set.getString("merModel"),
						set.getString("picture"), set.getString("merDesc"),
						set.getString("manufacturer"),
						set.getString("leaveFactoryDate"), set.getInt("special"));
				list.add(merchandiseModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return list;
	}
	
	/**
	 * 通过special 查询书籍
	 * @param special 是否为特价    1-是   0-新品
	 * @return 特价书籍集合或新品书籍集合
	 */
	public List<MerchandiseModel> getMerchandiseListBySpecial(int special) {
		ArrayList<MerchandiseModel> list = new ArrayList<MerchandiseModel>();
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select id,category,merName,price,sPrice,merModel,picture,merDesc,manufacturer,leaveFactoryDate,Special from Merchandise where Special=?";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, special);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				MerchandiseModel merchandiseModel = new MerchandiseModel(
						set.getInt("id"), set.getInt("category"),
						set.getString("merName"), set.getDouble("price"),
						set.getDouble("sPrice"), set.getString("merModel"),
						set.getString("picture"), set.getString("merDesc"),
						set.getString("manufacturer"),
						set.getString("leaveFactoryDate"), set.getInt("special"));
				list.add(merchandiseModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return list;
	}
	
	/**
	 * 通过id查询商品信息
	 * @param id 商品id
	 * @return 商品信息
	 */
	public MerchandiseModel getOneMerchandiseById(int id){
		MerchandiseModel merchandiseModel = null ;
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select m.ID,Category,MerName,Price,SPrice,MerModel,Picture,MerDesc,Manufacturer,LeaveFactoryDate,Special,c.cateName cateName from merchandise m,Category c where m.ID = ? and m.Category=c.ID";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				merchandiseModel = new MerchandiseModel(
						resultSet.getInt("id"), resultSet.getInt("category"),
						resultSet.getString("merName"), resultSet.getDouble("price"),
						resultSet.getDouble("sPrice"), resultSet.getString("merModel"),
						resultSet.getString("picture"), resultSet.getString("merDesc"),
						resultSet.getString("manufacturer"),
						resultSet.getString("leaveFactoryDate"), resultSet.getInt("special"),resultSet.getString("cateName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(connection, ps);
		}
		return merchandiseModel;
	}
	
	/**
	 * 通过书籍关键字和书籍分类目录查询
	 * @param qKey 书籍关键字      与书籍名匹配
	 * @param category 书籍目录id
	 * @return 书籍信息集合
	 */
	public List<MerchandiseModel> getMerchandiseListBySelect(String qKey,int category) {
		ArrayList<MerchandiseModel> list = new ArrayList<MerchandiseModel>();
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select id,category,merName,price,sPrice,merModel,picture,merDesc,manufacturer,leaveFactoryDate,Special from Merchandise where merName like '%"+ qKey +"%' and category=?";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, category);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				MerchandiseModel merchandiseModel = new MerchandiseModel(
						set.getInt("id"), set.getInt("category"),
						set.getString("merName"), set.getDouble("price"),
						set.getDouble("sPrice"), set.getString("merModel"),
						set.getString("picture"), set.getString("merDesc"),
						set.getString("manufacturer"),
						set.getString("leaveFactoryDate"), set.getInt("special"));
				list.add(merchandiseModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return list;
	}
	
	/**
	 * 通过书籍分类目录查询
	 * @param category 书籍目录id
	 * @return 书籍信息集合
	 */
	public List<MerchandiseModel> getMerchandiseListByCategory(int category) {
		ArrayList<MerchandiseModel> list = new ArrayList<MerchandiseModel>();
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select id,category,merName,price,sPrice,merModel,picture,merDesc,manufacturer,leaveFactoryDate,Special from Merchandise where category=?";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt (1, category);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				MerchandiseModel merchandiseModel = new MerchandiseModel(
						set.getInt("id"), set.getInt("category"),
						set.getString("merName"), set.getDouble("price"),
						set.getDouble("sPrice"), set.getString("merModel"),
						set.getString("picture"), set.getString("merDesc"),
						set.getString("manufacturer"),
						set.getString("leaveFactoryDate"), set.getInt("special"));
				list.add(merchandiseModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return list;
	}
	
	/**
	 * 通过书籍关键字查询
	 * @param qKey 书籍关键字      与书籍名匹配
	 * @return 书籍信息集合
	 */
	public List<MerchandiseModel> getMerchandiseListByQkey(String qKey) {
		ArrayList<MerchandiseModel> list = new ArrayList<MerchandiseModel>();
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select id,category,merName,price,sPrice,merModel,picture,merDesc,manufacturer,leaveFactoryDate,Special from Merchandise where merName like '%"+ qKey +"%'";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
//			ps.setString(1, qKey);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				MerchandiseModel merchandiseModel = new MerchandiseModel(
						set.getInt("id"), set.getInt("category"),
						set.getString("merName"), set.getDouble("price"),
						set.getDouble("sPrice"), set.getString("merModel"),
						set.getString("picture"), set.getString("merDesc"),
						set.getString("manufacturer"),
						set.getString("leaveFactoryDate"), set.getInt("special"));
				list.add(merchandiseModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return list;
	}
}
