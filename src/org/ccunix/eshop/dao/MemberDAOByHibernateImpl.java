package org.ccunix.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.ccunix.eshop.model.MemberModel;
import org.ccunix.eshop.util.DBManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 会员信息数据库操作类
 * 
 * @author Edith
 * 
 */
public class MemberDAOByHibernateImpl implements MemberDAOIface{

	@Override
	public MemberModel getMemberInfo(String username, String password) {
		MemberModel memberModel = null;
		Session session = null;
		String hql = "from MemberModel m where m.loginName=? and m.loginPwd=?";
		try {
			session = DBManager.getSession();
			List<MemberModel> memberModels = session.createQuery(hql).setParameter(0, username).setParameter(1, password).list();
			if(memberModels.size()>0){
				memberModel = memberModels.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.closeSession(session);
		}
		return memberModel;
	}

	@Override
	public int isExistMember(String username) {
		MemberModel memberModel = null;
		Session session = null;
		String hql = "from MemberModel m where m.loginName=?";
		try {
			session = DBManager.getSession();
			List<MemberModel> memberModels = session.createQuery(hql).setParameter(0, username).list();
			if(memberModels.size()>0){
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.closeSession(session);
		}
		return 0;
	}

	@Override
	public int getMemberMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertMember(MemberModel memberModel) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = DBManager.getSession();
			transaction = DBManager.getTransation(session);
			session.save(memberModel);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			DBManager.closeSession(session);
		}
		return false;
	}

	@Override
	public boolean updateMember(MemberModel memberModel) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = DBManager.getSession();
			transaction = DBManager.getTransation(session);
			session.update(memberModel);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			DBManager.closeSession(session);
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(new MemberDAOByHibernateImpl().isExistMember("tom"));
	}
}
