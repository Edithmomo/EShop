package org.ccunix.eshop.dao;

import java.util.List;

import org.ccunix.eshop.model.CategoryModel;
import org.ccunix.eshop.util.DBManager;
import org.hibernate.Query;
import org.hibernate.Session;


public class CategoryDAOByHibernateImpl implements CategoryDAOIface{

	public List<CategoryModel> getCategoryList() {
		List<CategoryModel> categoryModels = null;
		Session session = DBManager.getSession();
		String hql = "from CategoryModel";
		Query query = session.createQuery(hql);
		categoryModels = query.list();
		DBManager.closeSession(session);
		return categoryModels;
	}

	public CategoryModel getCategoryById(int id) {
		CategoryModel categoryModel = null;
		Session session = DBManager.getSession();
		String hql = "from CategoryModel c where c.id = ?";
		Query query = session.createQuery(hql).setParameter(0, id);
		List<CategoryModel> categoryModels = query.list();
		if(categoryModels.size()>=1){
			categoryModel = categoryModels.get(0);
		}
		DBManager.closeSession(session);
		return categoryModel;
	}
	public static void main(String[] args) {
		CategoryDAOByHibernateImpl categoryDAOByHibernateImpl = new CategoryDAOByHibernateImpl();
		/*List<CategoryModel> categoryModels = categoryDAOByHibernateImpl.getCategoryList();
		if(categoryModels.size()>0){
			for(CategoryModel c : categoryModels){
				System.out.println("id="+c.getId()+"\tname"+c.getCateName());
			}
		}*/
		CategoryModel categoryModel = categoryDAOByHibernateImpl.getCategoryById(3);
		System.out.println("id="+categoryModel.getId()+"\tname】="+categoryModel.getCateName());
	}
	
}
