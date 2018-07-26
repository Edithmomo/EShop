package org.ccunix.eshop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ccunix.eshop.dao.MerchandiseDAO;
import org.ccunix.eshop.model.CastPageModel;
import org.ccunix.eshop.model.MerchandiseModel;
/**
 * 查询书籍信息servlet
 * @author Edith
 *
 */
public class SelectMerchandiseServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String qkey = request.getParameter("qKey");
		if(qkey != null && qkey != ""){
			byte[] bte = qkey.getBytes("iso-8859-1");
		    qkey = new String(bte, "UTF-8");
		}
		String category = request.getParameter("category");
		if((qkey == null || qkey == "") && (category == null || category == "")){
			response.sendRedirect("logOut.html");
		}else{
			String nowPage = request.getParameter("nowPage");
			if(qkey==null){
				qkey = "";
			}
			if(nowPage==null){
				nowPage = "1";
			}
			CastPageModel castPageModel = new CastPageModel(5, Integer.parseInt(nowPage), qkey, category);
			castPageModel.makePageSelectData();
			request.setAttribute("castPage", castPageModel);
			request.getRequestDispatcher("/selectMerchandise.jsp").forward(request, response);
	   }
		
	}

}
