package org.ccunix.eshop.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ccunix.eshop.dao.CartSelectedmerDAOByHibernateImpl;
import org.ccunix.eshop.dao.CartSelectedmerDAOInface;
import org.ccunix.eshop.model.CartModel;
import org.ccunix.eshop.model.CartSelectedmerModel;
import org.ccunix.eshop.model.MemberModel;

import com.alibaba.fastjson.JSONObject;

/**
 * 购物车servlet
 * @author Edith
 * 
 */
public class ShopCartManagerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");
		boolean b = false;
		CartSelectedmerDAOInface cartSelectedmerDAO = new CartSelectedmerDAOByHibernateImpl();
		int merId = -1;
		int cartId = -1;
		switch (method) {
		case "query":
			System.out.println("查询购物车123。。。。。。。");
			req.getRequestDispatcher("/shopCartManager.jsp").forward(req, resp);
			break;
		case "add":
			System.out.println("添加商品。。。。。。。。。。。。");
			b= addShopCart(req,resp);
			System.out.println(b);
			break;
		case "delete":
			System.out.println("删除商品。。。。。。。。。。。。");
			cartId = Integer.parseInt(req.getParameter("cartId"));
			String fun = req.getParameter("fun");
			System.out.println("fun"+fun);
			System.out.println("0".equals(fun)+"   0");
			System.out.println("1".equals(fun)+"   1");
			if("0".equals(fun)){
				System.out.println("删除全部。。。。。。。。。。");
				b = cartSelectedmerDAO.deleteAllCartSelectedmer(cartId);
			}else{
				System.out.println("删除部分。。。。。。。。。。");
				merId = Integer.parseInt(req.getParameter("merId"));
				b = cartSelectedmerDAO.deleteOneCartSelectedmer(merId, cartId);
			}
			break;
		case "update":
			System.out.println("修改商品。。。。。。。。。。。。");
			merId = Integer.parseInt(req.getParameter("merId"));
			cartId = Integer.parseInt(req.getParameter("cartId"));
			int number = Integer.parseInt(req.getParameter("number"));
			if(number == 0){
				b = cartSelectedmerDAO.deleteOneCartSelectedmer(merId, cartId);
			}else{
				b = cartSelectedmerDAO.updateCartSelectedmer(cartId, merId, number, 0);
			}
			System.out.println(b);
			break;
		}
		resp.setCharacterEncoding("UTF-8");
		if(b){
			HttpSession session = req.getSession();
			CartModel cartModel = (CartModel) session.getAttribute("cartModel");
		    Map<Integer, CartSelectedmerModel> map = cartSelectedmerDAO.getCartSelectedmerMap(cartModel.getId());
		    cartModel.setCartSelectedmerMap(map);
		    cartModel.setMoney(getTotalMoney(map));
		    session.setAttribute("cartModel", cartModel);
		    System.out.println("更新session成功。。。。。。。。。。。。");
		    resp.getWriter().write(JSONObject.toJSONString(cartModel));
		}else{
			resp.getWriter().write("fail");
		}
	}

	/**
	 * 获取购物车中商品的总价
	 * 
	 * @param map
	 *            购物车商品集合
	 * @return 商品的总价
	 */
	public double getTotalMoney(Map<Integer, CartSelectedmerModel> map) {
		double s = 0;
		Set<Integer> set = map.keySet();
		Iterator<Integer> keys = set.iterator();
		while (keys.hasNext()) {
			Integer key = keys.next();
			s = s + map.get(key).getCartSelectedMerMoney();
			System.out.println(map.get(key).getMerName());
		}
		System.out.println("总价=" + s);
		return s;
	}
	
	/**
	 * 添加商品到购物车
	 * @param req
	 * @param resp
	 * @return
	 */
	public boolean addShopCart(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("添加商品到购物车。。。。。。。");
		int merId = Integer.parseInt(req.getParameter("merId"));
		double price = Double.parseDouble(req.getParameter("price"));
		int special = Integer.parseInt(req.getParameter("special"));
		HttpSession session = req.getSession(false);
		Object objCartModel = session.getAttribute("cartModel");
		boolean f = false;
		if (objCartModel != null) {
			CartModel cartModel = (CartModel) objCartModel;
			CartSelectedmerDAOInface cartSelectedmerDAO = new CartSelectedmerDAOByHibernateImpl();
			System.out.println(cartModel.getCartSelectedmerMap().containsKey(merId)+"------------------------------------------");
			if (cartModel.getCartSelectedmerMap().containsKey(merId)) {
				// 存在
				String strNumber = req.getParameter("number");
				int number = 0;
				if (strNumber == null) {
					number = 1;
				} else {
					number = Integer.parseInt(strNumber);
				}
				f = cartSelectedmerDAO.updateCartSelectedmer(
						cartModel.getId(), merId, number ,1);
			} else {
				if (special == 0) {
					MemberModel memberModel = (MemberModel) session
							.getAttribute("userInfo");
					int favourable = Integer.parseInt(memberModel.getMemberLevelModel().getFavourable());
					price = price *  0.01 * favourable;
				}
				f = cartSelectedmerDAO.addCartSelectedmer(
						cartModel.getId(), merId, price);
			}
		}
		return f;
		
	}
}
