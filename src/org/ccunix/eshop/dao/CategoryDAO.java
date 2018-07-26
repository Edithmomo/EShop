package org.ccunix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ccunix.eshop.model.CategoryModel;
import org.ccunix.eshop.model.UsersModel;
import org.ccunix.eshop.util.DBManager;

/**
 * 书籍分类的数据库访问类
 * @author Administrator
 *
 */
public class CategoryDAO {
	/**
	 * 获取所有的书籍目录名
	 * @return 目录名集合
	 */
	public List<CategoryModel> getCategoryList() {
		ArrayList<CategoryModel> list = new ArrayList<CategoryModel>();
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select id,catename,catedesc from Category";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				CategoryModel category = new CategoryModel(set.getInt("id"),
						set.getString("catename"),set.getString("catedesc"));
				list.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return list;
	}
	
	/**
	 * 通过书籍目录id 查询目录
	 * @param id 目录id
	 * @return 目录信息
	 */
	public CategoryModel getCategoryById(int id) {
		CategoryModel categoryModel = null;
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select id,catename,catedesc from Category where id = ?";
		if(id==0){
			sql= "select id,catename,catedesc from Category";
		}
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				categoryModel = new CategoryModel(set.getInt("id"),
						set.getString("catename"),set.getString("catedesc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return categoryModel;
	}
}
