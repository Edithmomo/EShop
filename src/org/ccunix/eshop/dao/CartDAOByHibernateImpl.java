package org.ccunix.eshop.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.ccunix.eshop.model.CartModel;
import org.ccunix.eshop.util.DBManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CartDAOByHibernateImpl implements CartDAOIface {

	@Override
	public CartModel isExistCart(int member) {
		CartModel cartModel = null;
		Session session = null;
		String hql = "from CartModel cm where cm.cartStatus = 0 and cm.member = "
				+ member;
		try {
			session = DBManager.getSession();
			List<CartModel> cartModelList = session.createQuery(hql).list();
			if (cartModelList.size() >= 1) {
				cartModel = cartModelList.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManager.closeSession(session);
		}
		return cartModel;
	}

	@Override
	public CartModel addCart(int member) {
		CartModel cartModel = null;
		Session session = null;
		Transaction transaction = null;
		CartModel cartModel2 = new CartModel();
		cartModel2.setMember(member);
		cartModel2.setCartStatus(0);
		session.save(cartModel2);
		String hql = "from CartModel cm where cm.cartStatus = 0 and cm.member = "
				+ member;
		try {
			session = DBManager.getSession();
			transaction = DBManager.getTransation(session);
			List<CartModel> cartModelList = session.createQuery(hql).list();
			if (cartModelList.size() >= 1) {
				cartModel = cartModelList.get(0);
			}
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DBManager.closeSession(session);
		}
		return cartModel;
	}

	@Override
	public boolean updateCart(Session session, int cartId) {
		String hql = "update CartModel c set c.money=(select sum(c.cartSelectedMerMoney) from CartSelectedmerModel c where c.cart = ?) where c.id=?";
		try {
			int row = session.createQuery(hql).setParameter(0, cartId)
					.setParameter(1, cartId)
					.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
	public boolean updateCart(Session session, int cartId,int i) {
		String hql = "update CartModel c set c.money=0  where c.id=?";
		try {
			int row = session.createQuery(hql).setParameter(0, cartId)
					.setParameter(1, cartId)
					.executeUpdate();
			if (row > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean updateCart(Connection connection, int cartId)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(new CartDAOByHibernateImpl().addCart(20).getId());
		Session session = DBManager.getSession();
		System.out
				.println(new CartDAOByHibernateImpl().updateCart(session, 21));
	}
}
