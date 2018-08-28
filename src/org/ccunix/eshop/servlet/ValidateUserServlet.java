package org.ccunix.eshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ccunix.eshop.dao.MemberDAOByHibernateImpl;
import org.ccunix.eshop.dao.MemberDAOIface;

public class ValidateUserServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		if(username != null){
			MemberDAOIface memberDAO = new MemberDAOByHibernateImpl();
			int e = memberDAO.isExistMember(username);
			PrintWriter out = resp.getWriter();
			out.write(e+"");
		}
	}
}
