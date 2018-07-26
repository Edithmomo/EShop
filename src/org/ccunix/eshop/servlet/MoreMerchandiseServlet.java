package org.ccunix.eshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ccunix.eshop.dao.MerchandiseDAO;
import org.ccunix.eshop.model.CastPageModel;
import org.ccunix.eshop.model.MerchandiseModel;
/**
 *显示更多书籍servlet
 */
public class MoreMerchandiseServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MerchandiseDAO merchandiseDAO = new MerchandiseDAO();
		String special = request.getParameter("special");
		String nowPage = request.getParameter("nowPage");
		if(nowPage == null){
			nowPage = "1";
		}
		if(special != null){
			CastPageModel castPageModel = new CastPageModel(Integer.parseInt(nowPage), 5, special);
			castPageModel.makePageData();
			request.setAttribute("castPage", castPageModel);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/moreMerchandise.jsp");
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect("/logOut.html");
		}
	}
}
