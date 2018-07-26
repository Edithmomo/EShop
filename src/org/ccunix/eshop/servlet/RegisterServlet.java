package org.ccunix.eshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ccunix.eshop.dao.MemberDAO;
import org.ccunix.eshop.model.MemberModel;
import org.ccunix.eshop.util.CharacterUtil;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String memberName = req.getParameter("memberName");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String zip = req.getParameter("zip");
		String email = req.getParameter("email");
		String method = req.getParameter("method");
		MemberModel memberModel = null;
		MemberDAO memberDAO = new MemberDAO();
		boolean flag = false;
		if(method.equals("register")){
			System.out.println("注册会员。。。。。。。。。");
			memberModel = new MemberModel(1, 1, username, password, memberName, phone, address, zip, "", "", 0, email);
			flag = memberDAO.insertMember(memberModel);
		}else{
			System.out.println("修改会员。。。。。。。。。");
			HttpSession session = req.getSession();
			MemberModel oldMemberModel = (MemberModel) session.getAttribute("userInfo");
			memberModel = new MemberModel(oldMemberModel.getId(), 1, username, password, memberName, phone, address, zip, oldMemberModel.getRegDate(), oldMemberModel.getLastDate(), oldMemberModel.getLoginTimes(), email);
			flag = memberDAO.updateMember(memberModel);
		}
	    resp.setCharacterEncoding("UTF-8");
	    PrintWriter out = resp.getWriter();
	    if(true){
	    	resp.getWriter().write("200");
	    }else{
	    	resp.getWriter().write("失败");
	    }
	}

}
