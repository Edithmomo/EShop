package org.ccunix.eshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ccunix.eshop.dao.CategoryDAOByHibernateImpl;
import org.ccunix.eshop.dao.CategoryDAOIface;
import org.ccunix.eshop.model.CategoryModel;
/**
 * 初始化servlet
 */
public class InitEshopServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 我可以封装数据
		CategoryDAOIface categoryDAO = new CategoryDAOByHibernateImpl();
		List<CategoryModel> catList = categoryDAO.getCategoryList();

		request.setAttribute("category", catList);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
