package org.ccunix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.ccunix.eshop.model.MemberModel;
import org.ccunix.eshop.util.DBManager;

/**
 * 会员信息数据库操作类
 * 
 * @author Edith
 * 
 */
public class MemberDAO {
	/**
	 * 通过用户名和密码查询用户信息
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 用户信息
	 */
	public MemberModel getMemberInfo(String username, String password) {
		MemberModel memberModel = null;
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select m.ID,Memberlevel,LoginName,LoginPwd,MemberName,Phone,Address,Zip,RegDate,LastDate,LoginTimes,EMail,LevelName,Favourable from member m,memberlevel m1 where m.Memberlevel=m1.id and LoginName = ? and LoginPwd = ?";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				memberModel = new MemberModel(set.getInt("ID"),
						set.getInt("Memberlevel"), set.getString("LoginName"),
						set.getString("LoginPwd"), set.getString("MemberName"),
						set.getString("Phone"), set.getString("Address"),
						set.getString("Zip"), set.getString("RegDate"),
						set.getString("LastDate"), set.getInt("LoginTimes"),
						set.getString("EMail"), set.getString("LevelName"),
						set.getInt("Favourable"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberModel;
	}

	/**
	 * 通过用户名确认该账号是否存在
	 * 
	 * @param username
	 *            用户名
	 * @return 1-存在 0-不存在
	 */
	public int isExistMember(String username) {
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select * from member where LoginName = ? ";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取会员表id的最大值
	 * 
	 * @return
	 */
	public int getMemberMaxId() {
		int maxId = -1;
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "select max(id) maxId from member";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			ResultSet set = ps.executeQuery(sql);
			if (set.next()) {
				maxId = set.getInt("maxId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxId;
	}

	/**
	 * 添加会员
	 * 
	 * @param memberModel
	 *            会员信息
	 * @return 成功或失败
	 */
	public boolean insertMember(MemberModel memberModel) {
		Date date = new Date();
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "insert into member (Memberlevel,LoginName,LoginPwd,MemberName,Phone,Address,Zip,RegDate,LoginTimes,EMail) "
				+ " value(?,?,?,?,?,?,?,?,?,?)";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			int i = 0;
			ps.setInt(++i, memberModel.getMemberlevel());
			ps.setString(++i, memberModel.getLoginName());
			ps.setString(++i, memberModel.getLoginPwd());
			ps.setString(++i, memberModel.getMemberName());
			ps.setString(++i, memberModel.getPhone());
			ps.setString(++i, memberModel.getAddress());
			ps.setString(++i, memberModel.getZip());
			ps.setTimestamp(++i, new java.sql.Timestamp(date.getTime()));
			ps.setInt(++i, memberModel.getLoginTimes());
			ps.setString(++i, memberModel.getEmail());
			int row = ps.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修该会员信息
	 * 
	 * @param memberModel
	 *            会员
	 * @return 成功 或 失败
	 */
	public boolean updateMember(MemberModel memberModel) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date regdate = null;
		java.util.Date lastdate = null;
		try {
			if(!"".equals(memberModel.getRegDate()) && memberModel.getRegDate()!= null){
				regdate = format.parse(memberModel.getRegDate());
			}
			if(!"".equals(memberModel.getLastDate()) && memberModel.getLastDate() != null){
				lastdate = format.parse(memberModel.getLastDate());
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection = null;
		PreparedStatement ps = null;
		String sql = "update  member set Memberlevel=?,LoginName=?,LoginPwd=?,MemberName=?,"
					  + "phone=?,Address=?,Zip=?,RegDate=?,LastDate=?,LoginTimes=?,EMail=? "
				      + " where ID=?";
		try {
			connection = DBManager.getConnection();
			ps = connection.prepareStatement(sql);
			int i = 0;
			ps.setInt(++i, memberModel.getMemberlevel());
			ps.setString(++i, memberModel.getLoginName());
			ps.setString(++i, memberModel.getLoginPwd());
			ps.setString(++i, memberModel.getMemberName());
			ps.setString(++i, memberModel.getPhone());
			ps.setString(++i, memberModel.getAddress());
			ps.setString(++i, memberModel.getZip());
			ps.setTimestamp(++i, new java.sql.Timestamp(regdate.getTime()));
			ps.setTimestamp(++i, new java.sql.Timestamp(regdate.getTime()));
			ps.setInt(++i, memberModel.getLoginTimes());
			ps.setString(++i, memberModel.getEmail());
			ps.setInt(++i, memberModel.getId());
			int row = ps.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
