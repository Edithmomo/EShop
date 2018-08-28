package org.ccunix.eshop.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ccunix.eshop.model.CartModel;
import org.ccunix.eshop.model.CartSelectedmerModel;
import org.ccunix.eshop.model.MerchandiseModel;
import org.ccunix.eshop.util.DBManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class test {
	public static void main(String[] args) {
	   Session session = DBManager.getSession();
	   Transaction transaction  = DBManager.getTransation(session);
//	   CartModel cartModel = new CartModel();
//	   cartModel.setCartStatus(1);
//	   cartModel.setMoney(100);
//	   cartModel.setMember(56);
//	   Query query = session.createQuery("delete from CartSelectedmerModel c where c.cart=21");
//	   int i =  query.executeUpdate();
//	   System.out.println(i);
//	   transaction.commit();
//	   Query query = session.createQuery("from MerchandiseModel m where m.id=7");
//	   List<MerchandiseModel> list = query.list();
//	   if(list.size()>0){
//		   for(MerchandiseModel cart:list){
//			   System.out.println("id="+cart.getMerName()+"\t类型="+cart.getCategoryModel().getCateName());
//			   Map<Integer, CartSelectedmerModel> map = cart.getCartSelectedmerMap();
//			   Set<Integer> set = map.keySet();
//			   Iterator<Integer> it = set.iterator();
//			   while(it.hasNext()){
//				   Integer key = it.next();
//				   System.out.println("商品id="+map.get(key).getMerchandise());
//			   }
//		   }
//	   }
//	   transaction.commit();
//	   DBManager.closeSession(session);
//	   session.delete(arg1)
//	   session.save(cartModel);
	}

}
