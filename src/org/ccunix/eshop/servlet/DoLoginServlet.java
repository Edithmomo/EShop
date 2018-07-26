package org.ccunix.eshop.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ccunix.eshop.dao.CartDAO;
import org.ccunix.eshop.dao.CartSelectedmerDAO;
import org.ccunix.eshop.dao.MemberDAO;
import org.ccunix.eshop.dao.MerchandiseDAO;
import org.ccunix.eshop.model.CartModel;
import org.ccunix.eshop.model.CartSelectedmerModel;
import org.ccunix.eshop.model.MemberModel;
import org.ccunix.eshop.model.MerchandiseModel;
import com.alibaba.fastjson.JSONObject;
/**
 * 登录servlet
 */
public class DoLoginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		if(username !=null){
		    byte[] bte = username.getBytes("iso-8859-1");
		    username = new String(bte,"UTF-8");
		}
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		MemberDAO memberDAO = new MemberDAO();
		MemberModel memberModel = memberDAO.getMemberInfo(username,password);
		response.setCharacterEncoding("UTF-8");
		if(memberModel != null){
			if("1".equals(remember)){
				Cookie c_username = new Cookie("username", username);
				Cookie c_password = new Cookie("password", password);
				c_username.setMaxAge(60*60*24*7);
				c_password.setMaxAge(60*60*24*7);
				c_username.setPath("/");
				c_password.setPath("/");
				response.addCookie(c_username);
				response.addCookie(c_password);
			}else{
				Cookie[] cookies = request.getCookies();
				for(Cookie c:cookies){
					if("username".equals(c.getName())){
						c.setValue(null);
						c.setMaxAge(0);
						c.setPath("/");
						response.addCookie(c);
					}
					if("password".equals(c.getName())){
						c.setValue(null);
						c.setPath("/");
						c.setMaxAge(0);
						response.addCookie(c);
					}
				}
			}
			CartDAO cartDAO = new CartDAO();
			CartModel cartModel = cartDAO.isExistCart(memberModel.getId());
			if(cartModel == null){
				cartModel = cartDAO.addCart(memberModel.getId());
			}else{
				CartSelectedmerDAO cartSelectedmerDAO = new CartSelectedmerDAO();
				Map<Integer, CartSelectedmerModel> map = cartSelectedmerDAO.getCartSelectedmerMap(cartModel.getId());
				cartModel.setCartSelectedmerMap(map);
			}
			HttpSession session = request.getSession(true);
			session.setAttribute("userInfo", memberModel);
			session.setAttribute("cartModel", cartModel);
			response.getWriter().write(JSONObject.toJSONString(memberModel));
		}
	}

}

















//MerchandiseDAO merchandiseDAO =new MerchandiseDAO();
//List<MerchandiseModel> merchandiseModels = merchandiseDAO.getMerchandiseList();
//JSONArray jsonArray = new JSONArray();
//for(MerchandiseModel m : merchandiseModels){
//	JSONObject jsonObject = new JSONObject();
//	jsonObject.put("MerName", m.getMerName());
//	jsonObject.put("LeaveFactoryDate", m.getLeaveFactoryDate());
//	jsonArray.add(jsonObject);
//}
//
//response.setCharacterEncoding("UTF-8");
//response.getWriter().write(jsonArray.toString());
