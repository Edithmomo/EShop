package org.ccunix.eshop.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ccunix.eshop.model.CartSelectedmerModel;
import org.ccunix.eshop.util.DBManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CartSelectedmerDAOByHibernateImpl implements
		CartSelectedmerDAOInface {
	CartDAOIface cartDAO = new CartDAOByHibernateImpl();

	@Override
	public Map<Integer, CartSelectedmerModel> getCartSelectedmerMap(int cartId) {
		Map<Integer, CartSelectedmerModel> cartSelectedmerMap = new HashMap<Integer, CartSelectedmerModel>();
		Session session = null;
		try {
			session = DBManager.getSession();
			String hql = "from CartSelectedmerModel c where c.cart=?";
			List<CartSelectedmerModel> cartSelectedmerModels = session
					.createQuery(hql).setParameter(0, cartId).list();
			if (cartSelectedmerModels.size() > 0) {
				for (CartSelectedmerModel c : cartSelectedmerModels) {
					cartSelectedmerMap.put(c.getMerchandise(), c);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.closeSession(session);
		}
		return cartSelectedmerMap;
	}

	@Override
	public boolean addCartSelectedmer(int cartId, int merId, double price) {
		CartSelectedmerModel cartSelectedmerModel = new CartSelectedmerModel();
		cartSelectedmerModel.setCart(cartId);
		cartSelectedmerModel.setMerchandise(merId);
		cartSelectedmerModel.setNumber(1);
		cartSelectedmerModel.setCartSelectedMerPrice(price);
		cartSelectedmerModel.setCartSelectedMerMoney(price);
		System.out.println("价格= "+price);
		Session session = null;
		Transaction transaction = null;
		try {
			session = DBManager.getSession();
			transaction = session.beginTransaction();
			session.save(cartSelectedmerModel);
			boolean b = cartDAO.updateCart(session, cartId);
			if (b) {
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			DBManager.closeSession(session);
		}
		return false;
	}

	@Override
	public boolean updateCartSelectedmer(int cartId, int merId, int number,
			int type) {
		Session session = null;
		Transaction transaction = null;
		String hql = "from CartSelectedmerModel c where c.cart=? and c.merchandise=?";
		try {
			session = DBManager.getSession();
			transaction = DBManager.getTransation(session);
			List<CartSelectedmerModel> list = (List<CartSelectedmerModel>) session
					.createQuery(hql).setParameter(0, cartId)
					.setParameter(1, merId).list();
			if (list.size() >= 1) {
				CartSelectedmerModel cartSelectedmerModel = list.get(0);
				if(type == 1){
					number += cartSelectedmerModel.getNumber();
				}
				cartSelectedmerModel.setNumber(number);
				cartSelectedmerModel.setCartSelectedMerMoney(number*cartSelectedmerModel.getCartSelectedMerPrice());
				session.update(cartSelectedmerModel);
				transaction.commit();
				boolean b = cartDAO.updateCart(session, cartId);
				if (b) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeSession(session);
		}
		return false;
	}

	@Override
	public boolean deleteOneCartSelectedmer(int merId, int cartId) {
		Session session = null;
		Transaction transaction = null;
		System.out.println("merId="+merId+"cartId="+cartId);
		String hql = "delete from CartSelectedmerModel c where c.cart=? and c.merchandise=?";
		try {
			session = DBManager.getSession();
			transaction = DBManager.getTransation(session);
			System.out.println("------------------------------");
			int row = session.createQuery(hql).setParameter(0, cartId)
					.setParameter(1, merId)
					.executeUpdate();
			System.out.println("row="+row);
			boolean b = cartDAO.updateCart(session, cartId);
			if (row>0 && b) {
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeSession(session);
		}
		return false;
	}

	@Override
	public boolean deleteAllCartSelectedmer(int cartId) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = DBManager.getSession();
			transaction = DBManager.getTransation(session);
			Query query = session.createQuery(
					"delete from CartSelectedmerModel c where c.cart=?")
					.setParameter(0, cartId);
			int i = query.executeUpdate();
			boolean b = cartDAO.updateCart(session, cartId , 0);
			if (i > 0 && b) {
				transaction.commit();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeSession(session);
		}
		return false;
	}

	public static void main(String[] args) {
		CartSelectedmerDAOByHibernateImpl byHibernateImpl = new CartSelectedmerDAOByHibernateImpl();
		byHibernateImpl.deleteOneCartSelectedmer(1, 24);
//		Map<Integer, CartSelectedmerModel> map = byHibernateImpl.getCartSelectedmerMap(24);
//		System.out.println(map.size());
//		System.out.println(map.get(1).getCartSelectedMerPrice());
//		System.out.println(map.get(1).getMerchandiseModel());
	}
}
