package org.ccunix.eshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.ccunix.eshop.model.MerchandiseModel;
import org.ccunix.eshop.util.DBManager;
import org.hibernate.Session;

public class MerchandiseDAOByHibernate implements MerchandiseDAOIface {

	@Override
	public List<MerchandiseModel> getMerchandiseList() {
		List<MerchandiseModel> merchandiseModels = new ArrayList<MerchandiseModel>();
		Session session = null;
		String hql = "from MerchandiseModel";
		try {
			session = DBManager.getSession();
			merchandiseModels = session.createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeSession(session);
		}
		return merchandiseModels;
	}

	@Override
	public List<MerchandiseModel> getMerchandiseListBySpecial(int special) {
		List<MerchandiseModel> merchandiseModels = new ArrayList<MerchandiseModel>();
		Session session = null;
		String hql = "from MerchandiseModel m where m.special=?";
		try {
			session = DBManager.getSession();
			merchandiseModels = session.createQuery(hql)
					.setParameter(0, special).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeSession(session);
		}
		return merchandiseModels;
	}

	@Override
	public MerchandiseModel getOneMerchandiseById(int id) {
		MerchandiseModel merchandiseModel = null;
		Session session = null;
		try {
			session = DBManager.getSession();
			merchandiseModel = (MerchandiseModel) session.get(
					MerchandiseModel.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeSession(session);
		}
		return merchandiseModel;
	}

	@Override
	public List<MerchandiseModel> getMerchandiseListBySelect(String qKey,
			int category) {
		List<MerchandiseModel> merchandiseModels = new ArrayList<MerchandiseModel>();
		Session session = null;
		String hql = "from MerchandiseModel m where m.category=? and m.merName like ?";
		try {
			session = DBManager.getSession();
			merchandiseModels = session.createQuery(hql)
					.setParameter(0, category)
					.setParameter(1, "%" + qKey + "%").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeSession(session);
		}
		return merchandiseModels;
	}

	@Override
	public List<MerchandiseModel> getMerchandiseListByCategory(int category) {
		List<MerchandiseModel> merchandiseModels = new ArrayList<MerchandiseModel>();
		Session session = null;
		String hql = "from MerchandiseModel m where m.category=?";
		try {
			session = DBManager.getSession();
			merchandiseModels = session.createQuery(hql)
					.setParameter(0, category).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeSession(session);
		}
		return merchandiseModels;
	}

	@Override
	public List<MerchandiseModel> getMerchandiseListByQkey(String qKey) {
		List<MerchandiseModel> merchandiseModels = new ArrayList<MerchandiseModel>();
		Session session = null;
		String hql = "from MerchandiseModel m where m.merName like ?";
		try {
			session = DBManager.getSession();
			merchandiseModels = session.createQuery(hql)
					.setParameter(0, "%" + qKey + "%").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeSession(session);
		}
		return merchandiseModels;
	}

	public static void main(String[] args) {
//		System.out.println(new MerchandiseDAOByHibernate()
//				.getMerchandiseListByQkey("ajax").size());
		System.out.println(new MerchandiseDAOByHibernate().getOneMerchandiseById(3)
				.getMerName());
	}
}
