package org.ccunix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.ccunix.eshop.model.UsersModel;
import org.ccunix.eshop.util.DBManager;

public class UsersDAO {
	public List<UsersModel> getUsersList() {
		ArrayList<UsersModel> list = new ArrayList<UsersModel>();
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select username,password,limits,name from users";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				UsersModel user = new UsersModel(set.getString("username"),
						set.getString("password"), set.getInt("limits"),
						set.getString("name"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return list;
	}
    public String ArraytoString(String[] arr){
    	String str="";
    	for(String s:arr){
    		str = str+s+",";//zuqiu,paiqiu,pingpangqiu,
    	}
    	
    	return str;
    }
	public boolean add(UsersModel usersModel) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "insert into users(username,password,limits,name,email,sex,phone,photo,hobby) " +
				"values (?,?,?,?,?,?,?,?,?)";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			int i = 0;
			ps.setString(++i, usersModel.getUsername());
			ps.setString(++i, usersModel.getPassword());
			ps.setInt(++i, usersModel.getLimits());
			ps.setString(++i, usersModel.getName());
			ps.setString(++i, usersModel.getEmail());
			ps.setString(++i, usersModel.getSex());
			ps.setString(++i, usersModel.getPhone());
			ps.setString(++i, usersModel.getPhoto());
			ps.setString(++i, ArraytoString(usersModel.getHobby()));
		    int row = ps.executeUpdate();
			if(row>0)
		    return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(connection, ps);
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(new UsersDAO().getUsersList().size());
	}
}
